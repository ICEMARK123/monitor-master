package com.electric.controllers;

import com.alibaba.fastjson.JSONObject;
import com.electric.beans.UserInfo;
import com.electric.services.UserAddService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by cherry on 2017/12/7.
 */
@Controller
@RequestMapping("/UserDeal")
public class UserController {
    @Resource(name="userAddService")
    private UserAddService userAddService;
    @RequestMapping("/addUser")
    public void addUser(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("进入UserController中的addUser方法中！");
        JSONObject json = new JSONObject();
        String message = "";
        String user_account = request.getParameter("user_account");
        String user_name = request.getParameter("user_name");
        String user_passwd = request.getParameter("user_passwd");
        String user_ident = request.getParameter("user_ident");
        UserInfo userInfo = userAddService.getUserByAccount(user_account);
        if(userInfo!=null){
            message = "该用户已经被注册！";
            System.out.println("该用户已经被注册！");
        }else{
            HashMap<String,String> map = new HashMap<>();
            map.put("user_account",user_account);
            map.put("user_name",user_name);
            map.put("user_passwd",user_passwd);
            if("admin".equals(user_ident)){
                map.put("user_ident","1");
            }else{
                map.put("user_ident","0");
            }
            if(userAddService.addUserInfo(map)){
                message = "用户添加成功！";
            }else{
                message = "用户添加失败！";
            }
        }
        json.put("message",message);
        response.getWriter().print(json.toJSONString());
    }
    @RequestMapping("/userSearch")
    public void userSearch(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String searLoginUser = request.getParameter("userName");
        JSONObject json = new JSONObject();
        String message = "";
        UserInfo auser = userAddService.getUserByName(searLoginUser);
        if(auser!=null){// 搜索的用户存在
            message = "用户存在！";
            System.out.println(auser.getUserName());
        }else{
            message = "该用户不存在！";
        }
        json.put("info",message);
        json.put("user",auser);
//        System.out.println("上次登陆时间"+auser.getLastLoginTime());
        System.out.println(message);
        response.getWriter().print(json.toJSONString());
    }
    //展示所有用户信息
    @RequestMapping("/showUsers")
    public void showUsers(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        List<UserInfo> userList = userAddService.getAllUser();
        request.setAttribute("UserList",userList);
        String url = "/admin/userManager/userManager.jsp";
        request.getRequestDispatcher(url).forward(request,response);
    }
    @RequestMapping("/deleteUser")
    public void deleteUser(HttpServletRequest request,HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        String userId = request.getParameter("userId");
        System.out.println("要删除的用户的账号时"+userId);
        String message = "";
        JSONObject json = new JSONObject();
        if(userAddService.deleteUser(userId)){
            message  = "用户删除成功！";
        }else{
            message = "用户删除失败！";
        }
        json.put("message",message);
        response.getWriter().print(json.toJSONString());
    }
    @RequestMapping("/modifyUser")
    public void modifyUser(HttpServletRequest request, HttpServletResponse response, HttpSession session)throws IOException{
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        JSONObject json = new JSONObject();
        String user_account = request.getParameter("user_account");
        String user_name = request.getParameter("user_name");
        String user_passwd = request.getParameter("user_passwd");
        String user_ident = request.getParameter("user_ident");
        String session_account = (String) session.getAttribute("account");
        UserInfo user = new UserInfo();
        user.setUserId(user_account);
        user.setPasswd(user_passwd);
        user.setUserName(user_name);
        if("admin".equals(user_ident)){
            user.setRootUser(true);
        }else{
            user.setRootUser(false);
        }
        String message ="";
        if(userAddService.modifyUser(user)){
            if(session_account.equals(user_account)){
                session.removeAttribute("USER");
                session.setAttribute("USER",user.getUserName() );
            }
            message = "修改成功！";
        }else{
            message = "修改失败！";
        }
        json.put("message",message);
        response.getWriter().print(json.toJSONString());
    }


    public UserAddService getUserAddService() {
        return userAddService;
    }

    public void setUserAddService(UserAddService userAddService) {
        this.userAddService = userAddService;
    }
}
