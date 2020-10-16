package com.jie.test.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.MailSendException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.util.Properties;

@Service("iMailServe")
public class IMailServiceImpl implements IMailServe {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * Spring Boot 提供了一个发送邮件的简单抽象，使用的是下面这个接口，这里直接注入即可使用
     */
    @Autowired
    private JavaMailSender mailSender;

    /**
     * 配置文件中我的qq邮箱
     */
    @Value("${spring.mail.from}")
    private String from;

    private static String mailFrom = null;// 指明邮件的发件人
    private static String password_mailFrom = null;// 指明邮件的发件人登陆密码
    private static String mailTo = null;	// 指明邮件的收件人
    private static String mailTittle = null;// 邮件的标题
    private static String mailText =null;	// 邮件的文本内容
    private static String mail_host =null;	// 邮件的服务器域名
    /**
     * 简单文本邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendSimpleMail(String to, String subject, String content) {
        try{

            //创建SimpleMailMessage对象
            SimpleMailMessage message = new SimpleMailMessage();
            //邮件发送人
            message.setFrom(from);
            //邮件接收人
            message.setTo(to);
            //邮件主题
            message.setSubject(subject);
            //邮件内容
            message.setText(content);
            //发送邮件
            mailSender.send(message);
        }catch (MailSendException e) {
            detectInvalidAddress((MailSendException) e);
            logger.error("发送邮件时发生异常！", e);
        }
    }

    /**
     * html邮件

     * @param subject 主题
     * @param content 内容
     */
    @Override
    public void sendHtmlMail(String subject, String content){
//        //获取MimeMessage对象
//        MimeMessage message = mailSender.createMimeMessage();
//        MimeMessageHelper messageHelper;
//        try {
//            messageHelper = new MimeMessageHelper(message, true);
//            //邮件发送人
//            messageHelper.setFrom(from);
//            //邮件接收人
//            messageHelper.setTo(to);
//            //邮件主题
//            message.setSubject(subject);
//            //邮件内容，html格式
//            messageHelper.setText(content, true);
//            //发送
//            mailSender.send(message);
//            //日志信息
//            logger.info("邮件已经发送。");
//        } catch (MailSendException | MessagingException e) {
//            detectInvalidAddress((MailSendException) e);
//            logger.error("发送邮件时发生异常！", e);
//        }
        mailFrom = "1150482495@qq.com";
       password_mailFrom = "ppqhxmvruhuabahb";
//        password_mailFrom="lrj0913.";
        mailTo = "liruijuan@wison.com";

//        mail_host = "smtp.263.net";
        mail_host = "smtp.qq.com";

        Properties prop = new Properties();
        prop.setProperty("mail.smtp.host", mail_host);
        prop.setProperty("mail.transport.protocol", "smtp");
        prop.setProperty("mail.smtp.auth", "true");

        // 使用JavaMail发送邮件的5个步骤

        // 1、创建session
        Session session = Session.getInstance(prop);
        // 开启Session的debug模式，这样就可以查看到程序发送Email的运行状态
        session.setDebug(true);
        // 2、通过session得到transport对象
        Transport ts = null;
        try {
            ts = session.getTransport();
            // 3、使用邮箱的用户名和密码连上邮件服务器，发送邮件时，发件人需要提交邮箱的用户名和密码给smtp服务器，用户名和密码都通过验证之后才能够正常发送邮件给收件人。
            ts.connect(mail_host, mailFrom, password_mailFrom);
            // 4、创建邮件
            Message message = createSimpleMail(session, mailFrom, mailTo, subject, content);
            // 5、发送邮件
            ts.sendMessage(message, message.getAllRecipients());
            // 邮件对象
            File file = new File("E:\\textmail.eml");
            // 获得输出流
            OutputStream ips = new FileOutputStream(file);
            // 把邮件内容写入到文件
            message.writeTo(ips);
            // 关闭流
            ips.close();
            System.out.println("发送完毕");
            ts.close();
        } catch (NoSuchProviderException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    /**
     * @Method: createSimpleMail
     * @Description: 创建一封只包含文本的邮件
     */
    public static MimeMessage createSimpleMail(Session session, String mailfrom, String mailTo, String mailTittle,
                                               String mailText) throws Exception {
        // 创建邮件对象
        MimeMessage message = new MimeMessage(session);
        // 指明邮件的发件人
        message.setFrom(new InternetAddress(mailfrom));
        // 指明邮件的收件人，
        message.setRecipient(Message.RecipientType.TO, new InternetAddress(mailTo));
        // 邮件的标题
        message.setSubject(mailTittle);
        // 邮件的文本内容
        message.setContent(mailText, "text/html;charset=UTF-8");
        // 返回创建好的邮件对象
        return message;
    }


    private void detectInvalidAddress(MailSendException me) {
        Exception[] messageExceptions = me.getMessageExceptions();
        if (messageExceptions.length > 0) {
            Exception messageException = messageExceptions[0];
            if (messageException instanceof SendFailedException) {
                SendFailedException sfe = (SendFailedException) messageException;
                Address[] invalidAddresses = sfe.getInvalidAddresses();
                if(invalidAddresses != null) {
                    StringBuilder addressStr = new StringBuilder();
                    for (Address address : invalidAddresses) {
                        addressStr.append(address.toString()).append("; ");
                    }

                    logger.error("发送邮件时发生异常！可能有无效的邮箱：{}", addressStr);
                    return;
                }
            }
        }

        logger.error("发送邮件时发生异常！", me);
    }
    /**
     * 带附件的邮件
     * @param to 收件人
     * @param subject 主题
     * @param content 内容
     * @param filePath 附件
     */
    @Override
    public void sendAttachmentsMail(String to, String subject, String content, String filePath) {
        MimeMessage message = mailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(from);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(content, true);

            FileSystemResource file = new FileSystemResource(new File(filePath));
            String fileName = filePath.substring(filePath.lastIndexOf(File.separator));
            helper.addAttachment(fileName, file);
            mailSender.send(message);
            //日志信息
            logger.info("邮件已经发送。");
        } catch (MessagingException e) {
            logger.error("发送邮件时发生异常！", e);
        }


    }
}
