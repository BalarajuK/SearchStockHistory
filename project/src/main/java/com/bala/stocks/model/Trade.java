package com.bala.stocks.model;

import java.util.Map;

public class Trade {

    private Map<String, Trade> tradeMap;

    public Map<String, Trade> getTradeMap() {
        return tradeMap;
    }

    public void setTradeMap(Map<String, Trade> tradeMap) {
        this.tradeMap = tradeMap;
    }
}
