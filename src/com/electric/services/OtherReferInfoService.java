package com.electric.services;

import com.electric.beans.RealTimeData;
import com.electric.mappers.OtherReferInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Service("otherReferInfoService")
public class OtherReferInfoService {
    @Autowired
    @Resource(name = "otherReferInfoMapper")
    private OtherReferInfoMapper otherReferInfoMapper;
    public List<RealTimeData> getAllData(String machineNo){
        return otherReferInfoMapper.getAllData(machineNo);
    }
    public List<RealTimeData> getRealTimeByTimeSpaceASC(String starttime, String endtime, String machineNo){
        return otherReferInfoMapper.getRealTimeByTimeSpaceASC(starttime, endtime, machineNo);
    }
    public List<RealTimeData> getRealTimeByTimeSpaceDESC(String starttime, String endtime, String machineNo){
        return otherReferInfoMapper.getRealTimeByTimeSpaceDESC(starttime, endtime, machineNo);
    }
}
