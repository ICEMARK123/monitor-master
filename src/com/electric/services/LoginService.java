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

	//通过ID获取用户
    public UserInfo getUserFromId(String userId){
        System.out.println("进入LoginService中的getUserFromId方法中！");
        return loginMapper.getUserFromId(userId);
    }
	//通过ID 获取用户最后登录时间
    public boolean updateLastLoginTime(String nowTime,String userId){
        return loginMapper.updateLastLoginTime(nowTime,userId)>0;
    }

}
