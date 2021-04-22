package com.ash.server.service;

import com.alipay.api.AlipayApiException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;

/**
 * <p>
 * 支付宝沙箱环境
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/20 13:34
 */
public interface AlipayService {

    /**
     * 支付宝支付调用接口
     * @param  oid
     * @param amount
     * @param response
     * @param request
     * @throws IOException
     */
    void  aliPay(Long oid, BigDecimal amount,HttpServletRequest request,HttpServletResponse response) throws IOException, AlipayApiException;

    /**
     * 支付宝退款调用接口
     * @param oid
     * @param amount
     * @param response
     * @param session
     */
    void refund(Long oid, BigDecimal amount, HttpServletResponse response, HttpSession session) throws IOException;
}
