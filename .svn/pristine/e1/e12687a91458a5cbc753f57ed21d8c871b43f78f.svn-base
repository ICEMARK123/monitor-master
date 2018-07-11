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
public interface AreferInfoMapper {
    List<RealTimeData> getAllRealTimeDate(String machineNo);
    List<RealTimeData> getRealTimeDataByTimespace(@Param("starttime")String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
    List<RealTimeData> getRealTimeDataBySpaceASC(@Param("starttime")String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
}
