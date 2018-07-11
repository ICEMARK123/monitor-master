package com.electric.mappers;

import com.electric.beans.RealTimeData;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
public interface OtherReferInfoMapper {
    List<RealTimeData> getAllData(String machineNo);
    List<RealTimeData> getRealTimeByTimeSpaceASC(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
    List<RealTimeData> getRealTimeByTimeSpaceDESC(@Param("starttime") String starttime,@Param("endtime") String endtime,@Param("machineNo") String machineNo);
}
