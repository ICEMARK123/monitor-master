package com.electric.mappers;

import com.electric.beans.RealTimeData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
public interface VreferInfoMapper {
    List<RealTimeData> getRealTimeByTimespace(@Param("starttime")String starttime,@Param("endtime") String endtime,@Param("machineno") String machineno);
    List<RealTimeData> getAllRealTimeData(String machineNo);
    List<RealTimeData> getRealTimesapceASC(@Param("starttime")String starttime,@Param("endtime") String endtime,@Param("machineno") String machineno);
}
