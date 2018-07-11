package com.electric.services;

import com.electric.beans.UserInfo;
import com.electric.mappers.UserAddMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by cherry on 2017/12/7.
 */
@Service("userAddService")
public class UserAddService {
    @Resource(name="userAddMapper")
    private UserAddMapper userAddMapper;

    public  UserInfo getUserByAccount(String user_account) {
        return userAddMapper.getUserByAccount(user_account);
    }
    public List<UserInfo> getAllUser(){
        return userAddMapper.getAllUser();
    }
    public boolean addUserInfo(Map map){
        return userAddMapper.addUserInfo(map)>0;
    }
    public UserInfo getUserByName(String user_name){
        return userAddMapper.getUserByName(user_name);
    }
    public boolean deleteUser(String userId){
        return userAddMapper.deleteUser(userId)>0;
    }
    public boolean modifyUser(UserInfo user){
        return userAddMapper.modifyUser(user)>0;
    }
    public UserAddMapper getUserAddMapper() {
        return userAddMapper;
    }

    public void setUserAddMapper(UserAddMapper userAddMapper) {
        this.userAddMapper = userAddMapper;
    }
}
