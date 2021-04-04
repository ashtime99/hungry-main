package com.ash.mail;

import com.ash.server.pojo.Admin;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.annotation.RabbitListeners;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.standard.expression.MessageExpression;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import java.util.Date;


/**
 * <p>
 * TODO
 * </p>
 *
 * @Author ash
 * @Date 2021/3/28 15:33
 * @Version 1.0
 **/
public class MailReceiver {
    private static final Logger LOGGER= LoggerFactory.getLogger(MailReceiver.class);

    @Autowired
    private JavaMailSender javaMailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private TemplateEngine templateEngine;

    @RabbitListener(queues = "mail.welcome")//mail.welcome
    public void handler(Admin admin){
        MimeMessage mimeMessage=javaMailSender.createMimeMessage();
        MimeMessageHelper helper=new MimeMessageHelper(mimeMessage);
        try{
            //发件人
            helper.setFrom(mailProperties.getUsername());
            //收件人
            helper.setTo("2356530007@qq.com");
            //主题
            helper.setSubject("欢迎邮件");
            //发送日期
            helper.setSentDate(new Date());

            Context context=new Context();

            context.setVariable("username",admin.getUsername());
            String mail=templateEngine.process("mail",context);
            helper.setText(mail,true);

            javaMailSender.send(mimeMessage);
        }catch (MessagingException e){
            LOGGER.error("邮件发送失败======>{}",e.getMessage());
        }
    }



}
