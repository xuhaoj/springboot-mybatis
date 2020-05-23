package com.xhj.springbootmybatis.controller;

import com.jackxu.FormatTemplate;
import com.xhj.springbootmybatis.domain.jack.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FormatController {

    @Autowired
    FormatTemplate formatTemplate;

    @RequestMapping("/formatTest")
    public String formatTest() {
        User user = new User();
        user.setId(123);
        user.setNumber("456");
        user.setPassword("abcdefg");
        user.setUsername("徐帅哥");
        return formatTemplate.doFormat(user);
    }
}
