package com.electric.mappers;

import com.electric.beans.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ICEMARK on 2017/11/14.
 * 实现登录Dao接口
 */
public interface LoginMapper {
	//查询用户
    UserInfo getUserFromId(@Param("userId") String userId);
	//用户最后登录时间
    int updateLastLoginTime(@Param("nowTime") String nowTime,@Param("userId")String userId);
}
