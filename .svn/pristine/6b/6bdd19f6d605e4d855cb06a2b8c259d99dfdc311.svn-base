package com.electric.controllers;

import com.electric.mappers.EquipStatisticMapper;
import com.electric.services.EquipStatisticService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpOutputMessage;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

/**
 * Created by cherry on 2017/12/24.
 */
@Controller
@RequestMapping("/equipStatistic")
public class EquipStatisticController {
    @Autowired
    @Resource(name = "equipStatisticService")
    private EquipStatisticService equipStatisticService;
    @RequestMapping("/showInfo")
    public void showInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws UnsupportedEncodingException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String number = request.getParameter("choice");
        String machineNo = (String) session.getAttribute("MACHINENO");
        switch(number){
            case "1":   //日运行时间
                break;
            case "2":   //日平均电压
                break;
            case "3":   //日平均电流
                break;
            case "4":   //日电压最大值、最小值
                break;
            case "5":   //日电流最大值、最小值
                break;
            case "6":   //日总有功
                break;
            case "7":   //日总无功
                break;
        }
    }
}
