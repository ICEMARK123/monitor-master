package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.DevTypeInfo;
import com.electric.beans.MesureSiteInfo;
import com.electric.services.MessureSiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
@Controller
@RequestMapping("/messureSite")
public class MessureSiteController {
    @Autowired
    @Resource(name = "messureSiteService")
    private MessureSiteService messureSiteService;

    @RequestMapping("/getMessureTypeList")
    public void getMessureTypeList(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<DevTypeInfo> devTypeInfoList = messureSiteService.getgetAllDevTypeList();
        request.setAttribute("DevTypeList", devTypeInfoList);
        System.out.println("设备类型表的数量是:"+devTypeInfoList.size());
        String url = "/admin/messuresite/devTypePage.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/addDevType")
    public void addDevType(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("进入添加设备类型处理中！");
        String typename = request.getParameter("typename");
        String selfname = request.getParameter("selfname");
        String whetheruse = request.getParameter("whetheruse");
        DevTypeInfo getdevTypeInfo = messureSiteService.getDevTypeInfoByName(typename);
        JSONObject json = new JSONObject();
        String message  = "";
        if(getdevTypeInfo!=null){//表示添加的设备类型名称已经存在，则不能添加
            message = "添加的类型名称已经存在，添加失败！";
        }else{
            DevTypeInfo devTypeInfo = new DevTypeInfo();
            System.out.println("类型名称："+typename+"自定义名称："+selfname+"是否使用:"+whetheruse);
            if("yes".equals(whetheruse)){
                devTypeInfo.setIsused(true);
            }else{
                devTypeInfo.setIsused(false);
            }
            devTypeInfo.setType_name(typename);
            devTypeInfo.setDev_selfName(selfname);

            if(messureSiteService.addDevType(devTypeInfo)){
                message = "添加成功！";
            }else{
                message = "添加失败！";
            }
        }
        json.put("message", message);
        response.getWriter().print(json.toJSONString());
    }
    @RequestMapping("/deleteDeal")
    public void deleteDeal(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String devType_id = request.getParameter("devType_id");
        System.out.println("要删除的设备类型id是"+devType_id);
        JSONObject jsonObject = new JSONObject();
        String message = "";
        if(messureSiteService.delDevType(Integer.parseInt(devType_id))){
            message = "删除成功！";
        }else{
            message = "删除失败！";
        }
        jsonObject.put("message", message);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/modifyDeal")
    public void modifyDeal(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String type_id = request.getParameter("type_id");
        String typename = request.getParameter("typename");
        String selfname = request.getParameter("selfname");
        String whetheruse = request.getParameter("whetheruse");
        DevTypeInfo devTypeInfo = new DevTypeInfo();
        if("yes".equals(whetheruse)){
            devTypeInfo.setIsused(true);
        }else{
            devTypeInfo.setIsused(false);
        }
        devTypeInfo.setType_id(Integer.parseInt(type_id));
        devTypeInfo.setType_name(typename);
        devTypeInfo.setDev_selfName(selfname);
        JSONObject jsonObject = new JSONObject();
        String message = "";
        if(messureSiteService.updateType(devTypeInfo)){
            message = "修改成功！";
        }else{
            message = "修改失败！";
        }
        jsonObject.putIfAbsent("message", message);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/searchByName")
    public void searchByName(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String typeName = request.getParameter("searchTypeName");
        String typename = "%"+typeName+"%";
        System.out.println(typename);
        List<DevTypeInfo> devTypeInfo = messureSiteService.getDevTypeByName(typename);
        System.out.println("搜索得到的设备类型的条数:"+devTypeInfo.size());
        for(int i =0;i<devTypeInfo.size();i++){
            System.out.println("第"+i+"个设备类型是否使用"+devTypeInfo.get(i).isIsused());
        }
        String message = "";
        if(devTypeInfo.size()!=0){
            message = "notNull";
        }else{
            message = "不存在！";
        }
        JSONObject json = new JSONObject();
        json.put("message",message);
        json.put("seachedList", devTypeInfo);
        response.getWriter().print(json.toJSONString());
    }
    /**
     * 设备台账列表
     */
    @RequestMapping("/getDeviceEquipment")
    public void getDeviceEquipment(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        List<MesureSiteInfo> devLedgeList = messureSiteService.getAllDeviceLedgerList();
        System.out.println("设备台账的信息共有："+devLedgeList.size());
        request.setAttribute("devLedgeList",devLedgeList);
        String url = "/admin/messuresite/devLedger.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/addDevLedger")
    public void addDevLedger(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String lineWay = request.getParameter("lineWay");
        String installLocation = request.getParameter("installLocation");
        String devDescript = request.getParameter("devDescript");
        String devCode = request.getParameter("devCode");
        String devTypeName = request.getParameter("devTypeName");
        String machineNo = request.getParameter("machineNo");
        String phonenumber = request.getParameter("phonenumber");
        JSONObject jsonObject = new JSONObject();
        String message = "";
        //判断机号是否已经存在
        MesureSiteInfo mesureSiteInfoFromNo = messureSiteService.getMessureSiteFromNo(machineNo);
        if(mesureSiteInfoFromNo==null){
            MesureSiteInfo mesureSiteInfo = new MesureSiteInfo();
            mesureSiteInfo.setLineWay(lineWay);
            mesureSiteInfo.setLocation(installLocation);
            mesureSiteInfo.setDevDescript(devDescript);
            mesureSiteInfo.setDevCode(devCode);
            mesureSiteInfo.setTypeId(messureSiteService.getIdByName(devTypeName));
            mesureSiteInfo.setMachineNo(machineNo);
            mesureSiteInfo.setPhonenumber(phonenumber);
            mesureSiteInfo.setSaveTime(new Date());
            mesureSiteInfo.setOnlineSituation(false);
            if(messureSiteService.addDevLedger(mesureSiteInfo)){
                message = "添加成功！";
            }else{
                message = "添加失败";
            }
        }else{//输入的机号已经存在
            message = "输入的机号已经存在！";
        }
        jsonObject.put("message",message);
        System.out.println(message);
        response.getWriter().print(jsonObject.toJSONString());

    }
    @RequestMapping("/getAllDevTypeName")
    public void getAllDevTypeName(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        List<String> devTypeNameList = messureSiteService.getAllDevTypeName();
        System.out.println("得到的类型名称的条数是:"+devTypeNameList.size());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("devTypeNameList",devTypeNameList);
        response.getWriter().print(jsonObject.toJSONString());
    }
    @RequestMapping("/modifyMessure")
    public void modifyMessure(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String lineWay = request.getParameter("lineWay");
        String installLocation = request.getParameter("installLocation");
        String devDescript = request.getParameter("devDescript");
        String devCode = request.getParameter("devCode");
        String devTypeName = request.getParameter("devTypeName");
        String machineNo = request.getParameter("machineNo");
        String phonenumber = request.getParameter("phonenumber");
        MesureSiteInfo mesureSiteInfo = new MesureSiteInfo();
        mesureSiteInfo.setLineWay(lineWay);
        mesureSiteInfo.setLocation(installLocation);
        mesureSiteInfo.setDevDescript(devDescript);
        mesureSiteInfo.setDevCode(devCode);
        mesureSiteInfo.setTypeId(messureSiteService.getIdByName(devTypeName));
        mesureSiteInfo.setMachineNo(machineNo);
        mesureSiteInfo.setPhonenumber(phonenumber);
        JSONObject jsonObject = new JSONObject();
        String message = "";
        if(messureSiteService.modifyMessure(mesureSiteInfo)){
            message = "修改成功！";
        }else{
            message = "修改失败！";
        }
        jsonObject.put("message",message );
        response.getWriter().print(jsonObject.toJSONString());
    }
//    根据位置模糊搜索设备台账信息
    @RequestMapping("/searchMessureInfo")
    public void searchMessureInfo(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String searchContent = request.getParameter("searchContent");
        String searthCondition = "%" + searchContent +"%";
        List<MesureSiteInfo> getMessureSiteList = messureSiteService.getDevLedgerByLocation(searthCondition);
        System.out.println("搜索得到的数据的条数是"+getMessureSiteList.size());
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("getMessureSiteList", getMessureSiteList);
        response.getWriter().print(jsonObject.toJSONString());
    }
}
