package com.electric.beans;

/**
 * Created by Lenovo on 2017/11/10.
 * 用户事务
 */
public class UserInfo {
//    userId               int                  not null,
//    userName             varchar(50)          null,
//    passwd               varchar(50)          null,
//    isRootUser           bit                  null,
	//用户ID
    private String userId;
	//用户名
    private String userName;
	//用户密码
    private String passwd;
	//是否管理员
    private boolean isRootUser;//对应数据库中类型为bit 整型数据 1、0 或 NULL。
	//最后登录时间
    private String lastLoginTime;//上次登陆时间
//    private String remart;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public boolean isRootUser() {
        return isRootUser;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public void setRootUser(boolean rootUser) {
        isRootUser = rootUser;
    }

//    public String getRemart() {
//        return remart;
//    }
//
//    public void setRemart(String remart) {
//        this.remart = remart;
//    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }
}
