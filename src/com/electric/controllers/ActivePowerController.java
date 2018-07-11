package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.RealTimeData;
import com.electric.services.ActivePowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.SystemEnvironmentPropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Controller
@RequestMapping("/activePower")
public class ActivePowerController {
    @Autowired
    @Resource(name = "activePowerService")
    private ActivePowerService activePowerService;
    @RequestMapping("/showAllActivePowerInfo")
    public void showAllActivePowerInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if ("".equals(machineNo) || machineNo == null) {
            machineNo = "01";
        }
        List<RealTimeData> realTimeDatasList = activePowerService.showAllRealTimeDataList(machineNo);
        request.setAttribute("realTimeDatasList", realTimeDatasList);
        String url = "/admin/devData/ActivePowerInfo.jsp";
        request.getRequestDispatcher(url).forward(request, response);
    }
    @RequestMapping("/lineShowByTimeSpace")
    public void lineShowByTimeSpace(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("进入显示a相有功功率的图形显示");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        String machineNo = (String) session.getAttribute("MACHINENO");
        if (machineNo == "" || machineNo == null) {
            machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        System.out.println(starttime + "  "+endtime);
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date = new Date();
        if(starttime == "" ||starttime == null){
            starttime  =new SimpleDateFormat("yyyy-MM-dd").format(date)+" 00:00";
        }
        if(endtime =="" || endtime == null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 23:59";
        }
        List<RealTimeData> realTimeDatasList = activePowerService.getRealTimeDataByTimeSpace(starttime,endtime,machineNo);
        List<String> timeList = new ArrayList<>();
        List<Float> paList = new ArrayList<>();
        List<Float> pbList = new ArrayList<>();
        List<Float> pcList = new ArrayList<>();
        List<Float> ptList = new ArrayList<>();
        for(int i = 0;i<realTimeDatasList.size();i++){
            timeList.add(realTimeDatasList.get(i).getSampleTime());
            paList.add(realTimeDatasList.get(i).getPa());
            pbList.add(realTimeDatasList.get(i).getPb());
            pcList.add(realTimeDatasList.get(i).getPc());
            ptList.add(realTimeDatasList.get(i).getPt());
        }
        jsonObject.put("timeList",timeList);
        jsonObject.put("paList",paList);
        jsonObject.put("pbList",pbList);
        jsonObject.put("pcList",pcList);
        jsonObject.put("ptList",ptList);
        jsonObject.put("machineNo",machineNo);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/tableShowByTimeSpace")
    public void tableShowByTimeSpace(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        System.out.println("进入显示a相有功功率的图形显示");
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JSONObject jsonObject = new JSONObject();
        String machineNo = (String) session.getAttribute("MACHINENO");
        if (machineNo == "" || machineNo == null) {
            machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        System.out.println(starttime + "  "+endtime);
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date = new Date();
        if("".equals(starttime) ||starttime == null){
            starttime  =new SimpleDateFormat("yyyy-MM-dd").format(date)+" 00:00";
        }
        if("".equals(endtime) || endtime == null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 23:59";
        }
        List<RealTimeData> realTimeDatasList = activePowerService.getRealTimeDataByTimeSpaceDESC(starttime,endtime,machineNo);
        jsonObject.put("realTimeDatasList",realTimeDatasList);
        System.out.println(realTimeDatasList.size());
        response.getWriter().print(jsonObject.toJSONString());
    }
}
