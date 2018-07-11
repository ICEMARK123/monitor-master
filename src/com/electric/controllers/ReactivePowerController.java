package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.RealTimeData;
import com.electric.services.ReactivePowerService;
import com.sun.org.glassfish.external.statistics.annotations.Reset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.WebFault;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by cherry on 2018/1/1.
 */
@Controller
@RequestMapping("/reactivePower")
public class ReactivePowerController {
    @Autowired
    @Resource(name = "reactivePowerService")
    private ReactivePowerService reactivePowerService;
    @RequestMapping("/showAllQInfo")
    public void showAllQInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if (machineNo == "" || machineNo == null) {
            machineNo = "01";
        }
        List<RealTimeData> realTimeDatasList = reactivePowerService.showAllRealTimeDataList(machineNo);
        request.setAttribute("realTimeDatasList", realTimeDatasList);
        String url = "/admin/devData/ReactivePowerInfo.jsp";
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
        List<RealTimeData> realTimeDatasList = reactivePowerService.getRealTimeDataByTimeSpace(starttime,endtime,machineNo);
        List<String> timeList = new ArrayList<>();
        List<Float> QaList = new ArrayList<>();
        List<Float> QbList = new ArrayList<>();
        List<Float> QcList = new ArrayList<>();
        List<Float> QtList = new ArrayList<>();
        for(int i = 0;i<realTimeDatasList.size();i++){
            timeList.add(realTimeDatasList.get(i).getSampleTime());
            QaList.add(realTimeDatasList.get(i).getQa());
            QbList.add(realTimeDatasList.get(i).getQb());
            QcList.add(realTimeDatasList.get(i).getQc());
            QtList.add(realTimeDatasList.get(i).getQt());
        }
        jsonObject.put("timeList",timeList);
        jsonObject.put("QaList",QaList);
        jsonObject.put("QbList",QbList);
        jsonObject.put("QcList",QcList);
        jsonObject.put("QtList",QtList);
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
        List<RealTimeData> realTimeDatasList = reactivePowerService.getRealTimeDataByTimeSpaceDESC(starttime,endtime,machineNo);
        jsonObject.put("realTimeDatasList",realTimeDatasList);
        System.out.println(realTimeDatasList.size());
        response.getWriter().print(jsonObject.toJSONString());
    }
}
