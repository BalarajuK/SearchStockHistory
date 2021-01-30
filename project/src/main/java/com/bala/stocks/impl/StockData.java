package com.bala.stocks.impl;

import com.bala.stocks.factory.FactoryMgr;
import com.bala.stocks.interfaces.IStockData;


import java.net.URL;

public class StockData implements IStockData {

    public static void main(String[] args) {
        //System.out.println(new UIUtils().getWelcomePage());

        URL classPath = StockData.class.getResource("StockData.class");
        System.out.println(classPath.getPath());
    }

    @Override
    public String getWelcomePageData() {
        return FactoryMgr.getFileServices().getFileContents(FactoryMgr.getFileServices().getWelcomePage());
    }
}
