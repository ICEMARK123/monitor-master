package com.electric.controllers;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.electric.beans.ComRefer;
import com.electric.beans.DevInfo;
import com.electric.services.DevInfoService;
import com.sun.org.apache.xalan.internal.xsltc.util.IntegerArray;
import com.sun.xml.internal.ws.resources.XmlmessageMessages;
import org.apache.ibatis.annotations.Param;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by cherry on 2017/12/23.
 */
@Controller
@RequestMapping("/devInfo")
public class DevInfoController {
    @Autowired
    @Resource(name = "devInfoService")
    private DevInfoService devInfoService;
    @RequestMapping("/showDevInfoList")
    public void showDevInfoList(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        List<DevInfo> list = devInfoService.getDevInfoList(machineNo);
//        System.out.println("------生产日期是:"+list.get(0).getProduction_date());
        System.out.println("设备信息共有:"+list.size());
        request.setAttribute("devInfoList",list);
        String url = "/admin/devInfo/devInfoMess.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/getComRefer")
    public void getComRefer(HttpServletRequest request,HttpServletResponse response,HttpSession session) throws ServletException, IOException {
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        List<ComRefer> comList = devInfoService.getComList(machineNo);
        System.out.println("通讯参数的条数："+comList.size());
        request.setAttribute("comreferList",comList);
        String url = "/admin/devInfo/commInfo.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
//    /*
//    * 删除通讯参数处理
//    * */
//    @RequestMapping("/deleteComRefer")
//    public void deleteComRefer(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        String devIp = request.getParameter("devIp");
//        JSONObject json = new JSONObject();
//        String message = "";
//        if(devInfoService.deleteComRefer(devIp)){
//            message = "删除成功！";
//        }else{
//            message = "删除失败！";
//        }
//        json.put("message",message);
//        response.getWriter().print(json.toJSONString());
//    }
//    @RequestMapping("/getAllMessureNo")
//    public void getAllMessureNo(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        List<String> machineNoList = devInfoService.getMachineNoList();
//        JSONObject json = new JSONObject();
//        json.put("machineNoList",machineNoList);
//        response.getWriter().print(json.toJSONString());
//    }
//    @RequestMapping("/deleteDevInfo")
//    public void deleteDevInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
//        request.setCharacterEncoding("utf-8");
//        response.setCharacterEncoding("utf-8");
//        String devId = request.getParameter("devId");
//        JSONObject json = new JSONObject();
//        String message = "";
//        if(devInfoService.delteDevInfo(devId)){
//            message = "删除成功！";
//        }else{
//            message = "删除失败！";
//        }
//        json.put("message",message );
//        response.getWriter().print(json.toJSONString());
//
//    }
    /*
    * time:2018-1-3
    * function:读取设备信息
    * */
    @RequestMapping("/readDevInfo")
    public void readDevInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String devId = request.getParameter("devId");
        System.out.println("设备Id是:"+devId);
        DevInfo devInfo = devInfoService.getDevInfoByDevId(Integer.parseInt(devId));
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("devInfo",devInfo);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/modifyDevInfo")
    public void modifyDevInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException, ParseException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        String useCompany = request.getParameter("useCompany");
        String softVersion = request.getParameter("softVersion");
        String installLocation = request.getParameter("installLocation");
        String hardVersion = request.getParameter("hardVersion");
        String produceDate = request.getParameter("produceDate");
        System.out.println("生产日期是1:"+produceDate);
        String devId = request.getParameter("devId");
        DevInfo devInfo = new DevInfo();
        if(produceDate ==""||produceDate == null){
            produceDate = devInfoService.getProduceDateFromDevId(devId);
        }
        System.out.println("生产日期是2:"+produceDate);
        devInfo.setProduction_date(produceDate);
        System.out.println("生产日期是3:"+devInfo.getProduction_date());
        devInfo.setDev_id(Integer.parseInt(devId));
        devInfo.setMachineNo(machineNo);
        devInfo.setInstall_location(installLocation);
        devInfo.setSoft_version(softVersion);
        devInfo.setHard_version(hardVersion);
        JSONObject json = new JSONObject();
        String message = "";
        if(devInfoService.modifyDevInfo(devInfo)){
            message = "修改成功！";
        }else{
            message = "修改失败！";
        }
        json.put("message",message );
        response.getWriter().print(json.toJSONString());

    }
    @RequestMapping("/addDevInfo")
    public void addDevInfo(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        String useCompany = request.getParameter("useCompany");
        String softVersion = request.getParameter("softVersion");
        String installLocation = request.getParameter("installLocation");
        String hardVersion = request.getParameter("hardVersion");
        String produceDate = request.getParameter("produceDate");
        DevInfo devInfo = new DevInfo();
        devInfo.setProduction_date(produceDate);
        devInfo.setUse_company(useCompany);
        devInfo.setMachineNo(machineNo);
        devInfo.setInstall_location(installLocation);
        devInfo.setSoft_version(softVersion);
        devInfo.setHard_version(hardVersion);
        JSONObject json = new JSONObject();
        String message = "";
        if(devInfoService.addDevInfo(devInfo)){
            message = "增加成功！";
        }else{
            message ="增加失败！";
        }
        json.put("message",message );
        response.getWriter().print(json.toJSONString());
    }
    @RequestMapping("/modifyComrefer")
    public void modifyComrefer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        String mainIp = request.getParameter("mainIp");
        String mainPort = request.getParameter("mainPort");
        String devIp = request.getParameter("devIp");
        String devPort = request.getParameter("devPort");
        String apn = request.getParameter("apn");
        String simNumber = request.getParameter("simNumber");
        String heartratestr = request.getParameter("heartrate");
        int heartrate = 0;
        if(heartratestr!=null&&heartratestr!=""){
            heartrate = Integer.parseInt(heartratestr);
        }
        ComRefer comRefer = new ComRefer();
        comRefer.setMachineNo(machineNo);
        comRefer.setMain_ipAddr(mainIp);
        comRefer.setMain_port(mainPort);
        comRefer.setDev_ip(devIp);
        comRefer.setDev_commPort(devPort);
        comRefer.setHeartrate(heartrate);
        System.out.println("设备Ip是:"+devIp);
        System.out.println("设备端口Ip是:"+devPort);
        comRefer.setApn(apn);
        comRefer.setSim_number(simNumber);
        JSONObject json = new JSONObject();
        String message = "";
        if(devInfoService.modifyComRefer(comRefer)){
            message = "修改成功！";
        }else{
            message = "修改失败！";
        }
        json.put("message",message );
        response.getWriter().print(json.toJSONString());
    }
    @RequestMapping("/readComrefer")
    public void readComrefer(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String devIp = request.getParameter("dev_Ip");
        ComRefer comRefer = devInfoService.getComReferByDevIp(devIp);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("comRefer",comRefer);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/addComrefer")
    public void addComrefer(HttpServletRequest request, HttpServletResponse response, HttpSession session) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String machineNo = (String) session.getAttribute("MACHINENO");
        if(machineNo==""||machineNo==null){
            machineNo = "01";
        }
        String mainIp = request.getParameter("mainIp");
        String mainPort = request.getParameter("mainPort");
        String devIp = request.getParameter("devIp");
        String devPort = request.getParameter("devPort");
        String apn = request.getParameter("apn");
        String simNumber = request.getParameter("simNumber");
        ComRefer comRefer = new ComRefer();
        comRefer.setMachineNo(machineNo);
        comRefer.setMain_ipAddr(mainIp);
        comRefer.setMain_port(mainPort);
        comRefer.setDev_ip(devIp);
        comRefer.setDev_commPort(devPort);
        System.out.println("设备Ip是:"+devIp);
        System.out.println("设备端口Ip是:"+devPort);
        comRefer.setApn(apn);
        comRefer.setSim_number(simNumber);
        JSONObject json = new JSONObject();
        String message = "";
        if(devInfoService.addComRefer(comRefer)){
            message = "添加成功！";
        }else{
            message = "添加失败！";
        }
        json.put("message",message );
        response.getWriter().print(json.toJSONString());
    }

}
