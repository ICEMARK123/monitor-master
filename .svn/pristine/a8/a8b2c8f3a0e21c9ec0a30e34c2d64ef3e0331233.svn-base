package com.electric.services;

import com.electric.beans.ComRefer;
import com.electric.beans.DevInfo;
import com.electric.mappers.DevInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cherry on 2017/12/23.
 */
@Service("devInfoService")
public class DevInfoService {
    @Autowired
    @Resource(name = "devInfoMapper")
    private DevInfoMapper devInfoMapper;
    public List<DevInfo> getDevInfoList(String machienNo){
        return devInfoMapper.getDevInfoList(machienNo);
    }
    public List<ComRefer> getComList(String machineNo){
        return devInfoMapper.getComList(machineNo);
    }
    public boolean deleteComRefer(String devIp){
        return devInfoMapper.deleteComRefer(devIp)>0;
    }
//    public List<String> getMachineNoList(){
//        return devInfoMapper.getMachineNoList();
//    }
    public boolean delteDevInfo(String devId){
        return devInfoMapper.delteDevInfo(devId)>0;
    }
    public boolean modifyDevInfo(DevInfo devInfo){
        return devInfoMapper.modifyDevInfo(devInfo)>0;
    }
    public String getProduceDateFromDevId(String devId){
        return devInfoMapper.getProduceDateFromDevId(devId);
    }
    public  boolean addDevInfo(DevInfo devInfo){
        return devInfoMapper.addDevInfo(devInfo)>0;
    }
    public boolean modifyComRefer(ComRefer comRefer){
        return devInfoMapper.modifyComRefer(comRefer)>0;
    }
    public boolean addComRefer(ComRefer comRefer){
        return devInfoMapper.addComRefer(comRefer)>0;
    }
    public DevInfo getDevInfoByDevId(int devId){
        return devInfoMapper.getDevInfoByDevId(devId);
    }
    public ComRefer getComReferByDevIp(String devIp){
        return devInfoMapper.getComReferByDevIp(devIp);
    }
}
