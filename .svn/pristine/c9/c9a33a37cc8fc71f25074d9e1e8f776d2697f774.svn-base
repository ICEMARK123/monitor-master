package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.RealTimeData;
import com.electric.services.OtherReferInfoService;
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
 * Created by cherry on 2018/1/1.
 */
@Controller
@RequestMapping("/showReferInfo")
public class OtherReferInfoController {
    @Autowired
    @Resource(name = "otherReferInfoService")
    private OtherReferInfoService otherReferInfoService;
    @RequestMapping("/showAllPowerFactor")
    public void showAllPowerFactor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        List<RealTimeData> getRealTimeDataList = otherReferInfoService.getAllData(machineNo);
        request.setAttribute("realTimeDatasList",getRealTimeDataList);
        String url = "/admin/devData/PowerFactor.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
//    显示所有的电压不平衡信息
    @RequestMapping("/showAllVImbanlance")
    public void showAllVImbanlance(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        List<RealTimeData> getRealTimeDataList = otherReferInfoService.getAllData(machineNo);
        request.setAttribute("realTimeDatasList",getRealTimeDataList);
        String url = "/admin/devData/VImbalance.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/showAllIImbalance")
    public void  showAllIImbalance(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        List<RealTimeData> getRealTimeDataList = otherReferInfoService.getAllData(machineNo);
        request.setAttribute("realTimeDatasList",getRealTimeDataList);
        String url = "/admin/devData/IImbalance.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/showFrequency")
    public void  showFrequency(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        List<RealTimeData> getRealTimeDataList = otherReferInfoService.getAllData(machineNo);
        request.setAttribute("realTimeDatasList",getRealTimeDataList);
        String url = "/admin/devData/Frequency.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/showTemperature")
    public void  showTemperature(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        List<RealTimeData> getRealTimeDataList = otherReferInfoService.getAllData(machineNo);
        request.setAttribute("realTimeDatasList",getRealTimeDataList);
        String url = "/admin/devData/Temperature.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/showLinePowerFactor")
    public void showLinePowerFactor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date = new Date();
        if("".equals(starttime)||starttime ==null){
            starttime = new SimpleDateFormat("yyyy-MM-dd").format(date) + " 00:00";
        }
        if("".equals(endtime)||endtime == null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date) + " 23:59";
        }
        JSONObject jsonObject = new JSONObject();
        List<RealTimeData> realTimeDatasList = otherReferInfoService.getRealTimeByTimeSpaceASC(starttime,endtime,machineNo);
        List<String> timeList = new ArrayList<>();
        List<Float> pfaList = new ArrayList<>();
        List<Float> pfbList = new ArrayList<>();
        List<Float> pfcList = new ArrayList<>();
        List<Float> pftList = new ArrayList<>();
        List<Float> vufList = new ArrayList<>();
        List<Float> yiList = new ArrayList<>();
        List<Float> fList = new ArrayList<>();
        List<Float> temperatureList = new ArrayList<>();
        for(int i = 0;i<realTimeDatasList.size();i++){
            timeList.add(realTimeDatasList.get(i).getSampleTime());
            pfaList.add(realTimeDatasList.get(i).getpFa());
            pfbList.add(realTimeDatasList.get(i).getpFb());
            pfcList.add(realTimeDatasList.get(i).getpFc());
            pftList.add(realTimeDatasList.get(i).getpFt());
            vufList.add(realTimeDatasList.get(i).getVuf());
            yiList.add(realTimeDatasList.get(i).getYi());
            fList.add(realTimeDatasList.get(i).getF());
            temperatureList.add(realTimeDatasList.get(i).getTemperature());
        }
        jsonObject.put("machineNo",machineNo);
        jsonObject.put("timeList",timeList);
        jsonObject.put("pfaList",pfaList);
        jsonObject.put("pfbList",pfbList);
        jsonObject.put("pfcList",pfcList);
        jsonObject.put("pftList",pftList);
        jsonObject.put("vufList",vufList);
        jsonObject.put("yiList",yiList);
        jsonObject.put("fList",fList);
        jsonObject.put("temperatureList",temperatureList);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/showTablePowerFactor")
    public void showTablePowerFactor(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if("".equals(machineNo)||machineNo ==null){
            machineNo = "01";
        }
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date = new Date();
        if("".equals(starttime)||starttime ==null){
            starttime = new SimpleDateFormat("yyyy-MM-dd").format(date) + " 00:00";
        }
        if("".equals(endtime)||endtime == null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date) + " 23:59";
        }
        JSONObject jsonObject = new JSONObject();
        List<RealTimeData> realTimeDatasList = otherReferInfoService.getRealTimeByTimeSpaceDESC(starttime,endtime,machineNo);
        jsonObject.put("realTimeDatasList",realTimeDatasList);
        response.getWriter().print(jsonObject.toJSONString());
    }


}
