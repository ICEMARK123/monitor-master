package com.electric.beans;

/**
 * Created by cherry on 2017/12/16.
 * 关联   通讯参数表
 * 主站IP  主站端口  设备IP 测量点机号  设备通讯端口 APN sim卡号
 */
public class ComRefer {
    private String main_ipAddr;
    private String main_port;
    private String dev_ip;
    private String machineNo;
    private String dev_commPort;
    private String apn;
    private String sim_number;
    private int heartrate;

    public String getMain_ipAddr() {
        return main_ipAddr;
    }

    public void setMain_ipAddr(String main_ipAddr) {
        this.main_ipAddr = main_ipAddr;
    }

    public String getMain_port() {
        return main_port;
    }

    public void setMain_port(String main_port) {
        this.main_port = main_port;
    }

    public String getDev_ip() {
        return dev_ip;
    }

    public void setDev_ip(String dev_ip) {
        this.dev_ip = dev_ip;
    }

    public String getMachineNo() {
        return machineNo;
    }

    public void setMachineNo(String machineNo) {
        this.machineNo = machineNo;
    }

    public String getDev_commPort() {
        return dev_commPort;
    }

    public void setDev_commPort(String dev_commPort) {
        this.dev_commPort = dev_commPort;
    }

    public String getApn() {
        return apn;
    }

    public void setApn(String apn) {
        this.apn = apn;
    }

    public String getSim_number() {
        return sim_number;
    }

    public void setSim_number(String sim_number) {
        this.sim_number = sim_number;
    }

    public int getHeartrate() {
        return heartrate;
    }

    public void setHeartrate(int heartrate) {
        this.heartrate = heartrate;
    }
}
