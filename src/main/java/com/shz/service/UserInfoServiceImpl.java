package com.shz.service;

import com.shz.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserInfoServiceImpl implements UserInfoService{
    @Autowired
    private UserInfoDao userInfoDao;

    public UserInfo findUserInfo(String username){
        return userInfoDao.findByUsername(username);
    }
}
