package com.bala.stocks.external.stocks;


import com.bala.stocks.model.Trade;
import com.bala.stocks.model.TradeDay;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


import java.io.IOException;
import java.util.*;

public class JSonParser {

    public static void main(String[] args) {
        String testjon = getTestJson();
        //new JSonParser().parseStock(testjon);
        List<TradeDay> trades = new JSonParser().getTrading(testjon);
        System.out.println(new JSonBuilder().createJSon(trades));
    }

    public List<TradeDay> getTrading(String json){
        JsonFactory factory = new JsonFactory();
        try {
            return getTradings(json, factory);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();

    }

    private List<TradeDay> getTradings(String json, JsonFactory factory) throws IOException {
        JsonParser parser = factory.createParser(json);
        ObjectMapper objectMapper = new ObjectMapper();

        JsonNode rootNode = objectMapper.readTree(parser);
        JsonNode jsonNode = rootNode.path("Time Series (Daily)");

        List<TradeDay> tradeDays = new ArrayList<>();
        Iterator<String> fieldNamesIterator = jsonNode.fieldNames();
        while (fieldNamesIterator.hasNext()) {
            String key = fieldNamesIterator.next();
            TradeDay tradeDay = objectMapper.readValue(jsonNode.get(key).toString(), TradeDay.class);
            tradeDay.setDate(key);
            tradeDays.add(tradeDay);
            //System.out.println(tradeDay);
        }
        return tradeDays;
    }


    public void parseStock(String json){
        JsonFactory factory = new JsonFactory();
        try {
            List<TradeDay> tradeDays = getTradings(json, factory);
            tradeDays.forEach(tradeDay -> System.out.println(tradeDay.toString()));

//            List<TradeDay> trades = new ArrayList<>();
//            jsonNode.forEach(node->trades.add(getTradeDay(node)));

//            Map<String, Map> map = objectMapper.readValue(jsonNode.toString(), Map.class);
//            System.out.println(map.size());
//
//            for(String key : map.keySet()){
//                //TradeDay trade = objectMapper.readValue(entry.getValue(), TradeDay.class);
//                //entry.getValue().setDate(entry.getKey());
//                // System.out.println(entry.getKey() + " "+entry.getValue().getOpen());
//                System.out.println(key);
//            }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Trade getTrade(JsonNode tradeNode) {
        ObjectMapper mapper = new ObjectMapper();
        Trade trade = null;
        try {
            trade = mapper.readValue(tradeNode.toString(), Trade.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return trade;
    }

    private TradeDay getTradeDay(JsonNode tradeNode) {
        //JsonNode trade = tradeNode.get("1. open");
        ObjectMapper mapper = new ObjectMapper();
        TradeDay trade = null;
        try {
            trade = mapper.readValue(tradeNode.toString(), TradeDay.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
      //  tradeNode.forEach(child-> System.out.println(child.get("1. open")));
        //System.out.println(tradeNode.get());
        return trade;
    }

    public static String getTestJson(){
        return "{\"Meta Data\": {\n" +
                "        \"1. Information\": \"Daily Time Series with Splits and Dividend Events\",\n" +
                "        \"2. Symbol\": \"BSE:IDEA\",\n" +
                "        \"3. Last Refreshed\": \"2021-01-22\",\n" +
                "        \"4. Output Size\": \"Compact\",\n" +
                "        \"5. Time Zone\": \"US/Eastern\"\n" +
                "    },\n" +
                "    \"Time Series (Daily)\": {\n" +
                "        \"2021-01-22\": {\n" +
                "            \"1. open\": \"12.91\",\n" +
                "            \"2. high\": \"13.09\",\n" +
                "            \"3. low\": \"12.4\",\n" +
                "            \"4. close\": \"12.7\",\n" +
                "            \"5. adjusted close\": \"12.7\",\n" +
                "            \"6. volume\": \"96501772\",\n" +
                "            \"7. dividend amount\": \"0.0000\",\n" +
                "            \"8. split coefficient\": \"1.0\"\n" +
                "        },\n" +
                "        \"2021-01-21\": {\n" +
                "            \"1. open\": \"13.35\",\n" +
                "            \"2. high\": \"13.64\",\n" +
                "            \"3. low\": \"12.8\",\n" +
                "            \"4. close\": \"12.88\",\n" +
                "            \"5. adjusted close\": \"12.88\",\n" +
                "            \"6. volume\": \"83896446\",\n" +
                "            \"7. dividend amount\": \"0.0000\",\n" +
                "            \"8. split coefficient\": \"1.0\"\n" +
                "        }\n" +
                "}\n" +
                "}";
    }


}
