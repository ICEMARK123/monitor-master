package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.ActivePowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Service("activePowerService")
public class ActivePowerService {
    @Autowired
    @Resource(name = "activePowerMapper")
    private ActivePowerMapper activePowerMapper;
    public List<RealTimeData> showAllRealTimeDataList(String machineNo){
        return activePowerMapper.showAllRealTimeDataList(machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimeSpace(String starttime,String endtime,String machineNo){
        return activePowerMapper.getRealTimeDataByTimeSpace(starttime, endtime, machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimeSpaceDESC(String starttime,String endtime,String machineNo){
        return activePowerMapper.getRealTimeDataByTimeSpaceDESC(starttime, endtime, machineNo);
    }
}
