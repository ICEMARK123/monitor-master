package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.VreferInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
@Service("vreferInfoService")
public class VreferInfoService {
    @Autowired
    @Resource(name = "vreferInfoMapper")
    private VreferInfoMapper vreferInfoMapper;

    public List<RealTimeData> getRealTimeByTimespace(String starttime,String endtime,String machineno){
        return vreferInfoMapper.getRealTimeByTimespace(starttime, endtime, machineno);
    }
    public List<RealTimeData> getAllRealTimeData(String machineNo){
        return vreferInfoMapper.getAllRealTimeData(machineNo);
    }
    public List<RealTimeData> getRealTimesapceASC(String starttime,String endtime,String machineno){
        return vreferInfoMapper.getRealTimesapceASC(starttime,endtime ,machineno );
    }

}
