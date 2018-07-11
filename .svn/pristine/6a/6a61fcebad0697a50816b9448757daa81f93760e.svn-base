package com.electric.mappers;

import com.electric.beans.RealTimeData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
public interface ActivePowerMapper {
    List<RealTimeData> showAllRealTimeDataList(String machineNo);
    List<RealTimeData> getRealTimeDataByTimeSpace(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
    List<RealTimeData> getRealTimeDataByTimeSpaceDESC(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
}
