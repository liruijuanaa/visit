package com.jie.test.controller;

import com.jie.test.responseModel.Response;
import com.jie.test.service.IMailServe;
import com.jie.test.responseModel.ResultUtil;
import com.jie.test.service.IMailServe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    /**
     * 注入发送邮件的接口
     */
    private final IMailServe mailService;

    public EmailController(IMailServe mailService) {
        this.mailService = mailService;
    }

//    接收人邮箱
    @Value("${spring.mail.to}")
    private String to;

    @RequestMapping(value = "/send", method = RequestMethod.GET)
    public Response sendEmail(){
        StringBuilder html =new StringBuilder();
        html.append("<!-- CSS goes in the document HEAD or added to your external stylesheet -->\n" +
                "<style type=\"text/css\">\n" +
                "table.hovertable {\n" +
                "\tfont-family: verdana,arial,sans-serif;\n" +
                "\tfont-size:11px;\n" +
                "\tcolor:#333333;\n" +
                "\tborder-width: 1px;\n" +
                "\tborder-color: #999999;\n" +
                "\tborder-collapse: collapse;\n" +
                "}\n" +
                "table.hovertable th {\n" +
                "\tbackground-color:#c3dde0;\n" +
                "\tborder-width: 1px;\n" +
                "\tpadding: 8px;\n" +
                "\tborder-style: solid;\n" +
                "\tborder-color: #a9c6c9;\n" +
                "}\n" +
                "table.hovertable tr {\n" +
                "\tbackground-color:#d4e3e5;\n" +
                "}\n" +
                "table.hovertable td {\n" +
                "\tborder-width: 1px;\n" +
                "\tpadding: 8px;\n" +
                "\tborder-style: solid;\n" +
                "\tborder-color: #a9c6c9;\n" +
                "}\n" +
                "</style>\n" +
                " \n" +
                "<!-- Table goes in the document BODY -->\n" +
                "<table class=\"hovertable\">\n" +
                "<tr>\n" +
                "\t<th>Info Header 1</th><th>Info Header 2</th><th>Info Header 3</th>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>Item 1A</td><td>Item 1B</td><td>Item 1C</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>Item 2A</td><td>Item 2B</td><td>Item 2C</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>Item 3A</td><td>Item 3B</td><td>Item 3C</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>Item 4A</td><td>Item 4B</td><td>Item 4C</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>Item 5A</td><td>Item 5B</td><td>Item 5C</td>\n" +
                "</tr>\n" +
                "</table>");
            mailService.sendHtmlMail(to,"主题：你好html邮件",html.toString());
            return ResultUtil.success();
    }
}
