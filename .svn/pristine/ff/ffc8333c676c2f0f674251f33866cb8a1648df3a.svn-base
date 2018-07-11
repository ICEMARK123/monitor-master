package com.electric.mappers;

import com.electric.beans.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ICEMARK on 2017/11/14.
 */
public interface LoginMapper {
    UserInfo getUserFromId(@Param("userId") String userId);
    int updateLastLoginTime(@Param("nowTime") String nowTime,@Param("userId")String userId);
}
