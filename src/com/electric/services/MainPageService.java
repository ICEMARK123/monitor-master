package com.electric.services;

import com.electric.beans.MesureSiteInfo;
import com.electric.mappers.MainPageMapper;
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
@Service("mainPageService")
public class MainPageService {
    @Autowired
    @Resource(name = "mainPageMapper")
    private MainPageMapper mainPageMapper;
    public List<MesureSiteInfo> getAllMessureList(){
        return mainPageMapper.getAllMessureList();
    }
}
