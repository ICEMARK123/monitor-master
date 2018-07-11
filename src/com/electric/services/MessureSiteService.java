package com.electric.services;

import com.electric.beans.DevTypeInfo;
import com.electric.beans.MesureSiteInfo;
import com.electric.mappers.MessureSiteMapper;
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
@Service("messureSiteService")
public class MessureSiteService {
    @Autowired
    @Resource(name = "messureSiteMapper")
    private MessureSiteMapper messureSiteMapper;

    public List<DevTypeInfo> getgetAllDevTypeList(){
        return messureSiteMapper.getAllDevTypeList();
    }
    public boolean addDevType(DevTypeInfo devTypeInfo){
        return messureSiteMapper.addDevType(devTypeInfo)>0;
    }
    public boolean delDevType(int devTypeid){
        return messureSiteMapper.delDevType(devTypeid)>0;
    }
    public boolean updateType(DevTypeInfo devTypeInfo){
        return messureSiteMapper.updateType(devTypeInfo)>0;
    }
    public List<DevTypeInfo> getDevTypeByName(String typename){
        return messureSiteMapper.getDevTypeByName(typename);
    }
    public List<MesureSiteInfo> getAllDeviceLedgerList(){
        return messureSiteMapper.getAllDeviceLedgerList();
    }
    public boolean deleteDevLedger(String machineNo){
        return messureSiteMapper.deleteDevLedger(machineNo)>0;
    }
    public List<String> getAllDevTypeName(){
        return messureSiteMapper.getAllDevTypeName();
    }
    public DevTypeInfo getDevTypeInfoByName(String typename){
        return messureSiteMapper.getDevTypeInfoByName(typename);
    }
    public int getIdByName(String typename){
        return messureSiteMapper.getIdByName(typename);
    }
    public boolean modifyMessure(MesureSiteInfo mesureSiteInfo){
        return messureSiteMapper.modifyMessure(mesureSiteInfo)>0;
    }
    public MesureSiteInfo getMessureSiteFromNo(String machineNo){
        return messureSiteMapper.getMessureSiteFromNo(machineNo);
    }
    public boolean addDevLedger(MesureSiteInfo mesureSiteInfo){
        return messureSiteMapper.addDevLedger(mesureSiteInfo)>0;
    }
    public List<MesureSiteInfo> getDevLedgerByLocation(String location){
        return messureSiteMapper.getDevLedgerByLocation(location);
    }
}
