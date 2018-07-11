package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.ApparentPowerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Service("apparentPowerService")
public class ApparentPowerService {
    @Autowired
    @Resource(name = "apparentPowerMapper")
    private ApparentPowerMapper apparentPowerMapper;
    public List<RealTimeData> showAllRealTimeDataList(String machineNo){
        return apparentPowerMapper.showAllRealTimeDataList(machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimeSpace(String starttime,String endtime,String machineNo){
        return apparentPowerMapper.getRealTimeDataByTimeSpace(starttime, endtime, machineNo);
    }
    public List<RealTimeData> getRealTimeDataByTimeSpaceDESC(String starttime,String endtime,String machineNo){
        return apparentPowerMapper.getRealTimeDataByTimeSpaceDESC(starttime, endtime, machineNo);
    }
}
