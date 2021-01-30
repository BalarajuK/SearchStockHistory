package com.bala.stocks.model.stock;

import java.util.List;
import java.util.stream.Collectors;

public class Stock {
    private String symbol;
    private String info;

    public List<Double> getStockPrices(List<Price> prices){

        return prices.stream()
                .map(Price::getHigh)
                .sorted()
                .collect(Collectors.toList());
    }

    public Double getHighest(List<Price> prices){

        return prices.stream()
                .max((a,b)->(int)(a.getHigh()-b.getHigh()))
                .map(Price::getHigh)
                .orElse(0.0);
    }

    public Double getLowest(List<Price> prices){

        return prices.stream()
                .min((a,b)->(int)(a.getHigh()-b.getHigh()))
                .map(Price::getHigh)
                .orElse(0.0);
    }


}
