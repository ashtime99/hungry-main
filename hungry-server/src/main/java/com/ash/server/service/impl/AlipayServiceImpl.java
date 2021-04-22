package com.ash.server.service.impl;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.request.AlipayTradePagePayRequest;
import com.alipay.api.request.AlipayTradeRefundRequest;
import com.ash.server.config.AlipayConfig;
import com.ash.server.service.AlipayService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.UUID;

/**
 * @author 陈司文
 * @date 2021/3/5 20:21
 */
@Slf4j
@Service
public class AlipayServiceImpl implements AlipayService {
    /**
     * 支付宝支付调用接口
     * @param oid
     * @param amount
     * @param response
     * @param request
     * @throws IOException
     */
    @Override
    public void aliPay(Long oid, BigDecimal amount,HttpServletRequest request,HttpServletResponse response) throws AlipayApiException, IOException {
        response.setContentType("text/html;charset=utf-8");

        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradePagePayRequest aliPayRequest = new AlipayTradePagePayRequest();
        aliPayRequest.setReturnUrl(AlipayConfig.return_url+"?oid="+String.valueOf(oid));
        aliPayRequest.setNotifyUrl(AlipayConfig.notify_url+"?oid="+String.valueOf(oid));

        //商户订单号，后台可以写一个工具类生成一个订单号，必填
        String order_number = new String(String.valueOf(oid));
        //付款金额，从前台获取，必填
        String total_amount = new String(String.valueOf(amount));
        //订单名称，必填
        String subject = new String("hungry系统支付");
        aliPayRequest.setBizContent("{\"out_trade_no\":\"" + order_number + "\","
                + "\"total_amount\":\"" + total_amount + "\","
                + "\"subject\":\"" + subject + "\","
                + "\"product_code\":\"FAST_INSTANT_TRADE_PAY\"}");
        //请求
        String result = alipayClient.pageExecute(aliPayRequest).getBody();
        //输出
        out.println(result);//以下写自己的订单代码

        out.flush();
        out.close();
    }

    @Override
    public void refund(Long oid, BigDecimal amount, HttpServletResponse response, HttpSession session) throws IOException {
        // 设置编码格式
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        //获得初始化的AlipayClient
        AlipayClient alipayClient = new DefaultAlipayClient(AlipayConfig.gatewayUrl, AlipayConfig.app_id, AlipayConfig.merchant_private_key, "json", AlipayConfig.charset, AlipayConfig.alipay_public_key, AlipayConfig.sign_type);
        //设置请求参数
        AlipayTradeRefundRequest alipayRequest = new AlipayTradeRefundRequest();
        //商户订单号，必填
        //String out_trade_no = new String(oid);
        //需要退款的金额，该金额不能大于订单金额，必填
        //String refund_amount = new String(String.valueOf(amount));
        //标识一次退款请求，同一笔交易多次退款需要保证唯一。如需部分退款，则此参数必传；不传该参数则代表全额退款
        String out_request_no = new String(UUID.randomUUID().toString());
        // 字符转义很重要
        alipayRequest.setBizContent("{\"out_trade_no\":\""+ oid +"\","
                + "\"refund_amount\":\""+ amount +"\","
                + "\"out_request_no\":\""+ out_request_no +"\"}");
        //请求
        String result = null;
        try {
            result = alipayClient.execute(alipayRequest).getBody();
        } catch (AlipayApiException e) {
            e.printStackTrace();
        }
        /**
         * 重定向
         */
        response.sendRedirect("/index");
    }
}
