package com.electric.controllers;

import com.electric.beans.MesureSiteInfo;
import com.electric.services.MainPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author ICEMARK
 * @date 2017/12/11 11:06
 * @email ${EMAIL}
 * @description
 */
@Controller
@RequestMapping("/mainPage")
public class MainPageController {
    @Autowired
    @Resource(name = "mainPageService")
    private MainPageService mainPageService;
    @RequestMapping("/messureList")
    public void messureList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<MesureSiteInfo> messureList = mainPageService.getAllMessureList();
        System.out.println("主页信息的条数是:"+messureList.size());
        request.setAttribute("messureList", messureList);
        String url = "/admin/mainPage.jsp";
        request.getRequestDispatcher(url).forward(request,response );
    }

}
