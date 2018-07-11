package com.electric.controllers;


import com.sun.image.codec.jpeg.JPEGCodec;
import com.sun.image.codec.jpeg.JPEGImageEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * Created by ICEMARK on 2017/11/14.
 */
@RequestMapping("/pass")
@Controller
public class SecurityController {
    public int ro(){
        int b=0;
        Random r=new Random();
        while(true){
            int a=(int)(r.nextDouble()*123);
            if(a>='a'&&a<='z'||a>='A'&&a<='Z'||a>47&&a<58){
                b=a;
                break;
            }
        }
        return b;
    }
    //得到随机颜色
    public Color getRandColor (int fc, int bc) {
        Random random = new Random();
        if (fc > 255) {
            fc = 255;
        }
        if (bc > 255) {
            bc = 255;
        }
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }
    //问题出现在没有进入到该controller里面
    @RequestMapping("/securityCode")
    public void securityCode(HttpServletRequest request, HttpServletResponse response){
        int width=160;
//        int width=80;
        int height=40;
        Random random=new Random();
        BufferedImage bimagine=new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);//从内存中产生一个图片
        Graphics p=bimagine.getGraphics();//得到画笔
        p.setFont(new Font(("Times New Roman"),Font.PLAIN,25));
        //画一个矩形
        p.setColor(getRandColor(100,150));
        p.drawRect(0,0,width,height);
        //填充背景
        Color c = new Color(211,211,211);
        p.setColor(c);
        p.fillRect(1,1,width-2,height-2);
        //画干扰线
        p.setColor(getRandColor(100,150));
        Random r=new Random();
        for(int i=0;i<20;i++){
            p.drawLine(r.nextInt(width),r.nextInt(height),r.nextInt(width),r.nextInt(height));
        }
        //生成随机数字
        String asstr="";
        for(int i=0;i<4;i++){
            char a=(char)ro();
            asstr+=a;
            p.setColor(new Color(20+random.nextInt(110),20+random.nextInt(110),20+random.nextInt(110)));
            p.drawString(a+"",40*i,20);
        }
        //输出图像到页面
        response.setContentType("image/jpeg");
        request.getSession().setAttribute("rand",asstr);
        try {
            JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(response.getOutputStream());
            encoder.encode(bimagine);
        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
