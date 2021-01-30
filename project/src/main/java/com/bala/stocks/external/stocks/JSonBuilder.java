package com.bala.stocks.external.stocks;

import com.bala.stocks.model.TradeDay;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;


public class JSonBuilder {

    public static void main(String[] args) {

    }

    public String createJSon(List<TradeDay> trades) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.writeValueAsString(trades);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "";
    }
}
