package com.example.springboot.mapper;

import com.example.springboot.entity.UserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserInfoMapper {
    List<UserInfo> queryUserList();
}
