package com.example.springboot.controller;

import lombok.extern.slf4j.Slf4j;
import com.example.springboot.entity.UserInfo;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class TestController {
    @Autowired
    private UserService userService;
    @Autowired
    private UserInfo userInfo;

    @RequestMapping("/query")
    @ResponseBody
    public List<UserInfo> queryUserList() throws Exception{
        List<UserInfo> userInfoList = userService.queryUserList();
        log.debug(String.valueOf("------->"+userInfoList));
        return userInfoList;
    }
}
