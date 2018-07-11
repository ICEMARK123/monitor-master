package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.ReacticePowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Service("reactivePowerService")
public class ReactivePowerService {
    @Autowired
    @Resource(name = "reacticePowerMapper")
    private ReacticePowerMapper reacticePowerMapper;
    public List<RealTimeData> showAllRealTimeDataList(String machineNo){
    return reacticePowerMapper.showAllRealTimeDataList(machineNo);
}
    public List<RealTimeData> getRealTimeDataByTimeSpace(String starttime,String endtime,String machineNo){
        return reacticePowerMapper.getRealTimeDataByTimeSpace(starttime, endtime, machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimeSpaceDESC(String starttime,String endtime,String machineNo){
        return reacticePowerMapper.getRealTimeDataByTimeSpaceDESC(starttime, endtime, machineNo);
    }
}
