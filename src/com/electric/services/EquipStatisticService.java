package com.electric.services;

import com.electric.mappers.EquipStatisticMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by cherry on 2017/12/24.
 */
@Service("equipStatisticService")
public class EquipStatisticService {
    @Autowired
    @Resource(name = "equipStatisticMapper")
    private EquipStatisticMapper equipStatisticMapper;
}
