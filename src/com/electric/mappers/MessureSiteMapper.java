package com.electric.mappers;

import com.electric.beans.DevTypeInfo;
import com.electric.beans.MesureSiteInfo;

import java.util.List;
import java.util.Map;

/**
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
public interface MessureSiteMapper {
    List<DevTypeInfo> getAllDevTypeList();
    int addDevType(DevTypeInfo devTypeInfo);
    int delDevType(int devTypeid);
    int updateType(DevTypeInfo devTypeInfo);
    List<DevTypeInfo> getDevTypeByName(String typename);
    List<MesureSiteInfo> getAllDeviceLedgerList();
    int deleteDevLedger(String machineNo);
    List<String> getAllDevTypeName();
    DevTypeInfo getDevTypeInfoByName(String typename);
    int getIdByName(String typename);
    int modifyMessure(MesureSiteInfo mesureSiteInfo);
    MesureSiteInfo getMessureSiteFromNo(String machineNo);
    int addDevLedger(MesureSiteInfo mesureSiteInfo);
    List<MesureSiteInfo> getDevLedgerByLocation(String location);
}
