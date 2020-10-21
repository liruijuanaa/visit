package com.jie.test.controller;

import com.jie.test.entity.Yuyue;
import com.jie.test.responseModel.Response;
import com.jie.test.service.IMailServe;
import com.jie.test.responseModel.ResultUtil;
import com.jie.test.service.IMailServe;
import com.jie.test.service.YuyueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@RequestMapping(value = "/email")
public class EmailController {

    @Resource
    private YuyueService yuyueService;
    /**
     * 注入发送邮件的接口
     */
    private final IMailServe mailService;

    public EmailController(IMailServe mailService) {
        this.mailService = mailService;
    }


    @RequestMapping(value = "/send", method = RequestMethod.POST)
    public Response sendEmail(@RequestBody Yuyue yuyue) {
        Date date=new Date();
        SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd");
        String time = dateFormat.format(date.getTime());
        yuyue.setApplydate(time);
        StringBuilder html = new StringBuilder();
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
                "\t<td>标题</td><td colspan=\"3\">" + yuyue.getTitle() + "</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>申请人</td><td>" + yuyue.getApplyname() + "</td><td>申请日期</td><td>" + yuyue.getApplydate() + "</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>访客姓名</td><td>" + yuyue.getGuestname() + "</td><td>访客手机号</td><td>" + yuyue.getGuesttel() + "</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>随行人数</td><td>" + yuyue.getFollowcount() + "</td><td>预约日期</td><td>" + yuyue.getGuestdate() + "</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>到达时间</td><td>" + yuyue.getGusettime() + "</td><td>到达地点</td><td>" + yuyue.getAddress() + "</td>\n" +
                "</tr>\n" +
                "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>来访交通方式</td><td>" + yuyue.getGuesttools() + "</td><td>是否车辆接送</td><td>" + yuyue.getGuestcar() + "</td>\n" +
                "</tr>\n" + "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>是否用餐安排</td><td>" + yuyue.getGuestfoods() + "</td><td>是否需要提供住宿</td><td>" + yuyue.getGuestacc() + "</td>\n" +
                "</tr>\n" +
                "</tr>\n" + "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>离开日期</td><td>" + yuyue.getGodate() + "</td><td>离开时间</td><td>" + yuyue.getGotime() + "</td>\n" +
                "</tr>\n" +
                "</tr>\n" + "<tr οnmοuseοver=\"this.style.backgroundColor='#ffff66';\" οnmοuseοut=\"this.style.backgroundColor='#d4e3e5';\">\n" +
                "\t<td>离开交通方式</td><td>" + yuyue.getGotools() + "</td><td>离开是否需要车辆</td><td>" + yuyue.getGocar() + "</td>\n" +
                "</tr>\n" +
                "</table>");
        try {
            mailService.sendHtmlMail("主题：访客信息", html.toString());

            //之后需要往数据库里存储信息
            this.yuyueService.insert(yuyue);
            System.out.println(yuyue);
            return ResultUtil.success();
        }catch (Exception e){
            return ResultUtil.error(300,e.getMessage());
        }
    }
}
