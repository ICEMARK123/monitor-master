package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.AreferInfoMapper;
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
@Service("areferInfoService")
public class AreferInfoService {
    @Autowired
    @Resource(name = "areferInfoMapper")
    private AreferInfoMapper areferInfoMapper;
    public List<RealTimeData> getAllRealTimeDate(String machineNo){
        return areferInfoMapper.getAllRealTimeDate(machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimespace(String starttime,String endtime,String machineNo){
        return areferInfoMapper.getRealTimeDataByTimespace(starttime,endtime ,machineNo );
    }
     public List<RealTimeData> getRealTimeDataBySpaceASC(String starttime,String endtime,String machineNo){
        return areferInfoMapper.getRealTimeDataBySpaceASC(starttime, endtime, machineNo);
     }

}
