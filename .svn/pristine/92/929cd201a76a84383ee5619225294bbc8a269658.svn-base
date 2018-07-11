package com.electric.services;

import com.electric.beans.UserInfo;
import com.electric.mappers.LoginMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by ICEMARK on 2017/11/14.
 */
@Service("loginService")
public class LoginService {
    @Autowired
    @Resource(name="loginMapper")
    private LoginMapper loginMapper;

    public UserInfo getUserFromId(String userId){
        System.out.println("进入LoginService中的getUserFromId方法中！");
        return loginMapper.getUserFromId(userId);
    }
    public boolean updateLastLoginTime(String nowTime,String userId){
        return loginMapper.updateLastLoginTime(nowTime,userId)>0;
    }

}
