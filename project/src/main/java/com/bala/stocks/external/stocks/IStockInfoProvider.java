package com.bala.stocks.external.stocks;


import com.bala.stocks.model.TradeDay;

import java.util.List;

public interface IStockInfoProvider {

    String getStockInfo(String company);

    List<TradeDay> getTrade(String company);
}
