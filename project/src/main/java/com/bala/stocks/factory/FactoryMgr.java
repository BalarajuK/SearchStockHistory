package com.bala.stocks.factory;


import com.bala.stocks.interfaces.IFileServices;
import com.bala.stocks.utils.FileService;

public class FactoryMgr {

    public static IFileServices getFileServices(){
        return new FileService();
    }
}
