//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//package com.xhj.springbootmybatis.controller;
//
//import com.jackxu.FormatTemplate;
//import com.xhj.springbootmybatis.domain.mybatisdemo.model.TUser;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.math.BigDecimal;
//
///**
// * @author xhj
// */
//@RestController
//public class FormatController {
//
//    @Autowired
//    FormatTemplate formatTemplate;
//
//    @RequestMapping("/formatTest")
//    public String formatTest() {
//        TUser TUser = new TUser();
//        TUser.setId(123L);
//        TUser.setName("徐帅哥");
//        TUser.setSalary(new BigDecimal(1000));
//        return formatTemplate.doFormat(TUser);
//    }
//
//}