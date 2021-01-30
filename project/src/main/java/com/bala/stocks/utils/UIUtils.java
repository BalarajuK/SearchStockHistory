package com.bala.stocks.utils;

import java.net.URL;

public class UIUtils {

    public static void main(String[] args) {
        System.out.println(new UIUtils().getWelcomePage());
    }

    public String getWelcomePage(){
        URL classPath = UIUtils.class.getResource("UIUtils.class");
        String path = classPath.getPath();
       // return path.substring(0,path.indexOf("utils/UIUtils.class"))+"ui/stocks.html";
        return "C:\\Balaraju\\OldLaptop\\Balaraju\\Programming\\repo\\gs-spring-boot\\complete\\src\\main\\java\\com\\bala\\stocks\\ui\\stocks.html";
    }
}
