package com.ash.server.controller;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSupport;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;

/**
 * <p>
 * 验证码
 * </p>
 *
 * @author ash
 * @version 1.0
 * @since 2021/3/29 12:07
 */
@RestController
@ApiSupport(order = 0)
@Api(tags = "验证码API")
public class CaptchaController {

    @Autowired
    private DefaultKaptcha defaultKaptcha;

    @ApiOperation(value = "验证码")
    @GetMapping(value = "/captcha",produces = "image/jpeg")
    public void captcha(HttpServletRequest request, HttpServletResponse response){
        //定义response输出类型为inage/jpeg类型
        response.setDateHeader ("Expires",0) ;
        // set standard HTTP/1.i_no-cache headers.
        response.setHeader( "MCache-Control","no-store,no-cache,must-revalidate");
        // set IE extended HTTP/1.1 no-cache headers (use addHeader).
        response.addHeader("Cache-Control","post-check=0,pre-check=0");
        // set standard HTTP/1.0 no-cache header .
        response.setHeader("Pragma","no-cache");
        // return a jpeg
        response.setContentType("image/jpeg");
        //---------------------------------  生成验证码 begin  ---------------------------------
        //获取验证码文本内容
        String text=defaultKaptcha.createText();
        System.out.println("验证码内容："+text);
        //将验证码文本内容放入session
        request.getSession().setAttribute("captcha",text);
        //根据文本验证码内容创建图形验证码
        BufferedImage image = defaultKaptcha.createImage(text);
        ServletOutputStream outputStream=null;
        try {
            outputStream=response.getOutputStream();
            ImageIO.write(image,"jpg",outputStream);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (null!=outputStream){
                try {
                    outputStream.close();
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        //---------------------------------  生成验证码 end  -----------------------------------
    }
}
