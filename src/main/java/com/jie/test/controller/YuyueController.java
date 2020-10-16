package com.jie.test.controller;

import com.jie.test.responseModel.Response;
import com.jie.test.responseModel.ResultUtil;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.jie.test.entity.Yuyue;
import javax.annotation.Resource;
import javax.xml.transform.Result;

import com.jie.test.service.YuyueService;
import java.util.*;
/**
 * (Yuyue)表控制层
 *
 * @author makejava
 * @since 2020-10-15 14:24:36
 */
@RestController
@RequestMapping(value = "/yuyue")
public class YuyueController {
    /**
     * 服务对象
     */
    @Resource
    private YuyueService yuyueService;

    /**
     * 通过主键查询单条数据
     *
     * @return 单条数据
     */
    @RequestMapping(value = "/queryPeople", method = RequestMethod.POST)
    public Response queryPeople(@RequestBody Yuyue yuyue) {
        try{
        List<Yuyue> result= this.yuyueService.queryAll(yuyue);
        return ResultUtil.success(result);
        }catch (Exception e){
            return ResultUtil.error(203,e.getMessage());
        }
    }

}