package com.electric.mappers;

import com.electric.beans.UserInfo;
import org.apache.ibatis.annotations.Param;

/**
 * Created by ICEMARK on 2017/11/14.
 * ʵ�ֵ�¼Dao�ӿ�
 */
public interface LoginMapper {
	//��ѯ�û�
    UserInfo getUserFromId(@Param("userId") String userId);
	//�û�����¼ʱ��
    int updateLastLoginTime(@Param("nowTime") String nowTime,@Param("userId")String userId);
}
