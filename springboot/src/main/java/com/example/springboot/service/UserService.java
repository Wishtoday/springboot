package com.example.springboot.service;

import com.example.springboot.entity.UserInfo;

import java.util.List;


public interface UserService {

    public List<UserInfo> queryUserList() throws Exception;
}
