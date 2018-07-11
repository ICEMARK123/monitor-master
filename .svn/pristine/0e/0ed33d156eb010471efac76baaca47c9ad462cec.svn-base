package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.RealTimeData;
import com.electric.services.VreferInfoService;
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
@RequestMapping("/vreferinfo")
public class VreferInfoController {
    @Autowired
    @Resource(name = "vreferInfoService")
    private VreferInfoService vreferInfoService;
    @RequestMapping("/getInfoByTimespace")
    public void getInfoByTimespace(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");  //首先先确定测量点的机号，同时保存在session里面
        if(machineNo==null||machineNo==""){
            machineNo = "01";               //首先先默认一个机号，进行测试
        }
        JSONObject jsonObject = new JSONObject();
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        System.out.println("开始时间："+starttime+"结束时间："+endtime);//开始时间：2017-12-20T12:00结束时间：2017-12-21T12:00
        starttime = starttime.replace("T"," ");
        endtime = endtime.replace("T"," ");
        Date date =new Date();
        if("".equals(starttime)||starttime==null){
            System.out.println("日期是：+++++"+date);
            starttime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 00:00";
            System.out.println("开始是时间是："+starttime+" 结束时间是："+endtime);
        }
        if(("").equals(endtime) ||endtime ==null){
            endtime = new SimpleDateFormat("yyyy-MM-dd").format(date)+" 23:59";
        }
        System.out.println("开始时间："+starttime);
        System.out.println("结束时间："+endtime);
        System.out.println("机号："+machineNo);
        String message = "";
        List<RealTimeData> realTimeDataList = vreferInfoService.getRealTimeByTimespace(starttime,endtime,machineNo);
        if(realTimeDataList.size()==0){
            message = "查询结果不存在!";
        }else{
            message = "notNull";
            System.out.println(realTimeDataList.get(0).getSampleTime());
            System.out.println(realTimeDataList.get(0).getUa());
            System.out.println(realTimeDataList.get(0).getUb());
            System.out.println(realTimeDataList.get(0).getUc());
        }
        System.out.println("查到记录共："+realTimeDataList.size());
        jsonObject.put("message",message );
        jsonObject.put("realtimeDataList",realTimeDataList );
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/showAllRealTimeData")
    public void showAllRealTimeData(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        List<RealTimeData> realTimeDataList = vreferInfoService.getAllRealTimeData(machineNo);
        System.out.println("测量点"+machineNo+"的所有实时数据的条数："+realTimeDataList.size());
        request.setAttribute("realTimeDataList",realTimeDataList);
        String url = "/admin/devData/VreferInfo.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/forLineShow")
    public void forLineShow(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");  //首先先确定测量点的机号，同时保存在session里面
        if(machineNo==null||machineNo==""){
            machineNo = "01";               //首先先默认一个机号，进行测试
        }
        JSONObject jsonObject = new JSONObject();
        String starttime = request.getParameter("starttime");
        String endtime = request.getParameter("endtime");
        System.out.println("开始时间是："+starttime);
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
        List<RealTimeData> realTimeDatasList = vreferInfoService.getRealTimesapceASC(starttime,endtime,machineNo);
        List<String> timeList = new ArrayList<>();
        List<Float> uaList = new ArrayList<>();
        List<Float> ubList = new ArrayList<>();
        List<Float> ucList = new ArrayList<>();
        for(int i = 0;i<realTimeDatasList.size();i++){
            timeList.add(realTimeDatasList.get(i).getSampleTime());
            uaList.add(realTimeDatasList.get(i).getUa());
            ubList.add(realTimeDatasList.get(i).getUb());
            ucList.add(realTimeDatasList.get(i).getUc());
        }
//        jsonObject.put("realTimeDatasList",realTimeDatasList);
        jsonObject.put("machineNo",machineNo);
        jsonObject.put("timeList",timeList);
        jsonObject.put("UaList",uaList);
        jsonObject.put("UbList",ubList);
        jsonObject.put("UcList",ucList);
        response.getWriter().print(jsonObject.toJSONString());
    }

}
