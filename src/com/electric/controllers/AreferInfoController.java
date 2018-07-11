package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.RealTimeData;
import com.electric.services.AreferInfoService;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
@Controller
@RequestMapping("/areferInfo")
public class AreferInfoController {
    @Autowired
    @Resource(name = "areferInfoService")
    private AreferInfoService areferInfoService;
    @RequestMapping("/showAllInfo")
    public void showAllInfo(HttpSession session, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo) || machineNo == null){
            machineNo = "01";
        }
        List<RealTimeData> realTimeDataList = areferInfoService.getAllRealTimeDate(machineNo);
        request.setAttribute("realTimeDataList", realTimeDataList);
        String url = "/admin/devData/AreferInfo.jsp";
        request.getRequestDispatcher(url).forward(request,response );
    }
    @RequestMapping("/showInfoByTimespace")
    public void showInfoByTimespace(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo) || machineNo == null){
                machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        starttime = starttime.replace("T", " ");
        endtime  =endtime.replace("T", " ");
        Date date = new Date();
        if("".equals(starttime)||starttime==null){
            System.out.println("日期是：+++++"+date);
            starttime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 00:00";
            System.out.println("开始是时间是："+starttime+" 结束时间是："+endtime);
        }
        if(("").equals(endtime) ||endtime ==null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 23:59";
        }
        List<RealTimeData> getRealTimeDataList = areferInfoService.getRealTimeDataByTimespace(starttime,endtime,machineNo);
        JSONObject jsonObjects = new JSONObject();
        jsonObjects.put("getRealTimeDataList", getRealTimeDataList);
        response.getWriter().print(jsonObjects.toJSONString());
    }
    @RequestMapping("/forLineShow")
    public void forLineShow(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo) || machineNo == null){
            machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date = new Date();
        if("".equals(starttime)||starttime==null){
            System.out.println("日期是：+++++"+date);
            starttime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 00:00";
            System.out.println("开始是时间是："+starttime+" 结束时间是："+endtime);
        }
        if(("").equals(endtime) ||endtime ==null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 23:59";
        }
        List<RealTimeData> getRealTimeList = areferInfoService.getRealTimeDataBySpaceASC(starttime,endtime,machineNo);
        List<String> timeList = new ArrayList<>();
        List<Float> IaList = new ArrayList<>();
        List<Float> IbList = new ArrayList<>();
        List<Float> IcList = new ArrayList<>();
        for(int i = 0;i<getRealTimeList.size();i++){
            timeList.add(getRealTimeList.get(i).getSampleTime());
            IaList.add(getRealTimeList.get(i).getIa());
            IbList.add(getRealTimeList.get(i).getIb());
            IcList.add(getRealTimeList.get(i).getIc());
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("machineNo",machineNo);
        jsonObject.put("timeList", timeList);
        jsonObject.put("iaList", IaList);
        jsonObject.put("ibList", IbList);
        jsonObject.put("icList", IcList);
        response.getWriter().print(jsonObject.toJSONString());
    }
}
