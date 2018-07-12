package com.electric.controllers;

        import com.alibaba.fastjson.JSONObject;
        import com.electric.beans.UserInfo;
        import com.electric.services.LoginService;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Controller;
        import org.springframework.web.bind.annotation.RequestMapping;

        import javax.annotation.Resource;
        import javax.servlet.ServletException;
        import javax.servlet.http.HttpServletRequest;
        import javax.servlet.http.HttpServletResponse;
        import javax.servlet.http.HttpSession;
        import java.io.IOException;
        import java.text.SimpleDateFormat;
        import java.util.Date;

/**
 * Created by ICEMARK on 2017/11/14.
 登录功能的控制器
 */
@Controller
@RequestMapping(value = "/login")
public class LoginController {
	/*
	* 登录服务
	*/
    @Resource(name="loginService")
    private LoginService loginService;
	
	//检查验证码是否正确
    @RequestMapping("/check")  
    public void check(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("检查验证码书否输入正确！");
        String securityCode = request.getParameter("vercode");
        String yanzhengma = (String)request.getSession().getAttribute("rand");
        JSONObject json = new JSONObject();
        if(yanzhengma!=null){ //判断存储的验证码是不是空
            yanzhengma = yanzhengma.toLowerCase();
        }
        if(securityCode!=null&&!securityCode.equals(yanzhengma)){
            json.put("result_jieguo",false);
        }else{
            json.put("result_jieguo",true);
        }
        response.getWriter().print(json.toJSONString());
    }
	//验证登录信息
    @RequestMapping("/checkAccount") 
    public void checkAccount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        System.out.println("进入LoginController中的checkAccount方法当中！");
        String account = request.getParameter("account");
        String passwd = request.getParameter("passwd");
        String ident = request.getParameter("ident");
        Date date = new Date();
//      SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");//说明：hh:mm:ss式12小时制
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//这个是24小时制
        String nowTime = simpleDateFormat.format(date);
        HttpSession  session = request.getSession();
        session.setAttribute("nowTime",nowTime);
//        时间测试数据
        JSONObject json = new JSONObject();
        String message = "";
        UserInfo anotherUser = loginService.getUserFromId(account);//根据账号得到用户
//        System.out.println("账号："+anotherUser.getUserId());
//        System.out.println("用户名："+anotherUser.getUserName());
//        System.out.println("密码："+anotherUser.getPasswd());
//        System.out.println("管理员："+anotherUser.isRootUser());
        if(anotherUser!=null){
            if(passwd!=null&&!passwd.equals(anotherUser.getPasswd())){//密码不一致
                message = "密码有误！";
            }else if(ident!=null&&ident.equals("admin")&&!anotherUser.isRootUser()||ident!=null&&ident.equals("user")&&anotherUser.isRootUser()){//身份不是管理员
                message = "请确定您的身份！";
            }else{
                session.setAttribute("account",anotherUser.getUserId());
                session.setAttribute("USER",anotherUser.getUserName());
                System.out.println("上次使用时间："+session.getLastAccessedTime());
                message = "success";
            }
        }else{
            message = "账户不存在！";
        }
        json.put("checkResult",message);
        System.out.println(message);
        response.getWriter().print(json.toJSONString());
    }
    //TODO:解决上次登陆时间的问题，尤其处理用户关闭浏览器时的情况
    //time：2017-12-10 20：03
    @RequestMapping("/logout")
    public void logout(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        String nowTime = (String) request.getSession().getAttribute("nowTime");
        String account = (String) request.getSession().getAttribute("account");
        if(loginService.updateLastLoginTime(nowTime,account)){
            System.out.println("最后登陆时间更新");
        }
        request.getSession().setAttribute("USER",null);
        String url = "/";
        request.getRequestDispatcher(url).forward(request,response);
    }



    public LoginService getLoginService() {
        return loginService;
    }

    public void setLoginService(LoginService loginService) {
        this.loginService = loginService;
    }
}

