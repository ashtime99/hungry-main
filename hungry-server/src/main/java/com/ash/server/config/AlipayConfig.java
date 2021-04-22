package com.ash.server.config;

import com.alipay.api.AlipayApiException;
import com.alipay.api.AlipayClient;
import com.alipay.api.DefaultAlipayClient;
import com.alipay.api.internal.util.AlipaySignature;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/4/19 14:27
 */
@Configuration
public class AlipayConfig {

    //↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
    public static String app_id = "2016082600316020";

    // 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIICdgIBADANBgkqhkiG9w0BAQEFAASCAmAwggJcAgEAAoGBAIClyf36hO/MIIPabFcyi77LdR5QHMtXtG6AC2TlvPMxcOcXIJKZ1TE/+x1bFAri6pTP8TtU7LnRZN7c1Gs1sXKtamacdW0VXTOXmDeJLnYpMjLjwU76ldmuo43gXiHiJ/1YivE08fuvg8ZITpSbjiXzeRamGIzLZ1U49iDFTOtlAgMBAAECgYBce1KHU3YHkR36y6XA1aRiZ47tWLgqcgVSvpfyU7mOtocsiZKv8Qiy3ATg6J2y6cerbQVFGtsHBgHWuLe3zqSd9Ruj+hdDeDmrb9+yyE9fWxhbIScgzXAMs+kjqs7kYHbviJjiEJSk1kWnAM4BsUk3GXc1CMnoRaqBL/gU0cvcgQJBAPJ1rr4xyzk5nZ8G1mUHFkWru9jdsaOoVxTZrr3MtEpB8YQEQLSfTBlGm2j+d9n4m1WR+ByycX2ga6rIUP3v8CECQQCH1P7d8p4WFAlJ0sgo16AUmrnpsWbQda85DW6BMZYyojd/j9SyxuJdnHlOUaAqDcb7ZOb+NVgKAjCZWWnELOLFAkEAyjgk2jSljsDjGbOWNQTIKqulLKcadaj9mEJGX77Pz+9YBAeYAA2sZphhHhy+0WlsBN6N1UFvLpwRsIsKIgFwgQJAE5pHldxXuDP4CzFiNZK4xYB26CT0A42YVhF8KyTu2ivS+pPVTF+rd3sHfqgFB0yptMohE/q60+bxAJCI1QjtSQJAeswb8PbHge9FFItpVeYFn7sKXZiNzcLEhrO4qaxRDUdyUM9pPvAcSj4s7mLRvvMF0Q3PBByUOx7/VL841JiUAg==";

    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQDIgHnOn7LLILlKETd6BFRJ0GqgS2Y3mn1wMQmyh9zEyWlz5p1zrahRahbXAfCfSqshSNfqOmAQzSHRVjCqjsAw1jyqrXaPdKBmr90DIpIxmIyKXv4GGAkPyJ/6FTFY99uhpiq0qadD/uSzQsefWo0aTvP/65zi3eof7TcZ32oWpwIDAQAB";

//    // 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
//    public static String app_id = "2021000117640780";
//
//    // 商户私钥，您的PKCS8格式RSA2私钥
//    public static String merchant_private_key = "MIIEvgIBADANBgkqhkiG9w0BAQEFAASCBKgwggSkAgEAAoIBAQCi5sPcwRVFdQ58hlASrfOrGkkOtyzAVRHQFgfL/Wy/B+qUF1QEvt7OhGeVuB+7NvAjZq8IahcOdpimHDBEFWyY4EA8cGZRs0QJc6oeJXj8PIOCjwoKZAwkZURilLEjsA5DtmFLQsv7JJedj3UxlIHh6TEKkaz877eVQEBRFkomYpGZoSztiGrnv4Fz1hYCqTK99HWl53DrphV8ZOpcI8RyZ4i3iP0zELCpdhGuqoZ28UVIV5XTzrGA9s2EHugZaBsofqU1hTU0B+pClL1y/8jUiM1IJS7wYwFCOSPrxwHZMYx2Y5lFOphsU2rzQ+TYrJwerM/xx5wbR14pY9oncTp7AgMBAAECggEBAIOSiZ3SoeCgxBuVzDTaJRYMu/dTwaRy0VlVgeSkAuJkfXYxRV4z3/fDf3qw5YgrvleJh1PvhEHdTjvURrOm7jin35oxWqMgfJJ5xmxk7cwlAD9CUuTDm/8Ff+9zk4N0noDYXMsR33kwO/k5tnleLm2OEFsuAB+naor1Az27GBbZeMteDo8IWO9x2Y1Etu/aI6Vkb0mzVZHf8Y/Kkq1HRSAjpZpSwaZvgKsinkOr2VFTSlFAfdzJDNP3eml98NAjIi2JL2q040xHFoNrKpsTeTQ+qGmHCbF4QkW2fYljt4kIsGmeTmvNESWpml9gbkUtues/4/oldWOyjoafvt/uuWkCgYEA4I2GmTfwdxQDyz7l1eKEzRfcZCoz7HEG9AuPSbOZKU+VDPSCQwmwOgeBAA2ktIBeroBv3mKir76H4cCoLDl9MV9q9+s0ntvM6JFyRJzbAV/DPvZ7vwbR+WoG4TBRIsP99zbLja5bktS6VOcSk31kJRZ7OrR9VDEpdSFaAnWyPU0CgYEAubb3XT4TEMX61wtyUSgBcVSrbVkeYQ6RAufXOeM9aW0w7ZHgxuAWNNExLCjYS82lFu471++UKdGKWIW+/Jzwn5VrJr6wc9PArGCKCpPKCgAMV3qw3VnBJLemL4Xm6SJEojaKrrAzjQ2xKTu8BRNRo5MQbxD5F2Bq+wMLy0Q+kucCgYAeNOuWUOAYJKkd/igMzZvvuvX6w3KYq9uzmJp935sK45m5VGrxeawrIjdIOo2demdCMiTaVYps+cRtqez1hgZBTgSltQ4vEIJQBsDIWhFb7fXl0mJzIAe+9XRXdphzhMn1J3naZUoMRnGKWks1a/i8xHlvPDhfyv04tHPXQN3pQQKBgG9QngBDnsXlBS80azb91a+KYp5OVokyY/Tr5fOKo1q32iXr1GEgG+9YnDKt4Me+4X9XGIOb1KEkOdpJgGqF3yyoMOuuTLGAcPJhgxxH7UgFM2CT58Mlc0GA2pmNlxSSN7VLH+EJOD0JwfDHHzGjnMGA+s63y7YZUsZV0xHpO+BtAoGBAKyh4sB2pknLPabSo8vLs3guEhaymf+KV8IWyWTwpTJlis8HvYaH+Gu/+kSLHpTb3v5vYZo+qRQoKnPyOjI63u/QnaBvKhIBLPaE9jMJBDo+KUu6LuMccWHlsdNsz88q7v5sCM88tqslJJBILTZNrckA+nniL1ZiCWzJujqEQc7O";
//
//    // 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
//    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAkKasH6aYIM0Qh6IycmMVGm8XBFz4saFFefMZ98DbQ30RsMWXy3H2LB3xE1afi/0SJiQAIhuQ+s9MtHz+G7Alcff5xB8IxeZN5hFGmfisl46hFm64OTNvSSjNEVDIR6/7+y99FkHvcH5AEHaXOVBEzpd3NleEM1ElodMcWsxHC5nCJ2W6usAZthtUmIFX91c3807ZKdYDZgtiu+yLjXd4KS8Eo2vSrav7qnBC2YmogSd2jIboR35mCNPnuYyF6C96tTO/ohiHODzkiA3Jcc4jIWV2rPNMIVtNPZGxuZl7NAZNg7HLTQeF5qrTCW7jxredFln0EyAviAd8rTtvx3rf+QIDAQAB";

    // 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String notify_url = "http://localhost:8081/food/settlement";

    //// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
    public static String return_url = "http://localhost:8081/food/settlement";

    // 签名方式
    public static String sign_type = "RSA";

    // 字符编码格式
    public static String charset = "utf-8";

    // 支付宝网关
    public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";



//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

}

