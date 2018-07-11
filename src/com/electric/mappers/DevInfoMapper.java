package com.electric.mappers;

import com.electric.beans.ComRefer;
import com.electric.beans.DevInfo;

import java.util.List;

/**
 * Created by cherry on 2017/12/23.
 */
public interface DevInfoMapper {
    List<DevInfo> getDevInfoList(String machineNo);
    List<ComRefer> getComList(String machineNo);
    int deleteComRefer(String devIp);
    List<String> getMachineNoList();
    int delteDevInfo(String devId);
    int modifyDevInfo(DevInfo devInfo);
    String getProduceDateFromDevId(String devId);
    int addDevInfo(DevInfo devInfo);
    int modifyComRefer(ComRefer comRefer);
    int addComRefer(ComRefer comRefer);
    DevInfo getDevInfoByDevId(int devId);
    ComRefer getComReferByDevIp(String devIp);

}
