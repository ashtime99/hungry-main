package com.ash.server.pojo;

import java.io.Serializable;

/**
 * <p>
 * 支付宝回调参数
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/20 11:56
 */
public class AliReturnPayBean implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * 开发者的app_id
     */
    private String app_id;

    /**
     * 商户订单号
     */
    private String out_trade_no;

    /**
     * 签名
     */
    private String sign;

    /**
     * 交易状态
     */
    private String trade_status;

    /**
     * 支付宝交易号
     */
    private String trade_no;

    /**
     * 交易的金额
     */
    private String total_amount;


}