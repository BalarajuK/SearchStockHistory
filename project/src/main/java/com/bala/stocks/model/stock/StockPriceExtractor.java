package com.bala.stocks.model.stock;


//import com.fasterxml.jackson.core.JsonFactory;
//import com.fasterxml.jackson.core.JsonParser;
//import com.fasterxml.jackson.core.JsonToken;
//import jdk.nashorn.internal.parser.JSONParser;
//import org.glassfish.jersey.client.ClientResponse;
//
//import javax.ws.rs.client.Client;
//import javax.ws.rs.client.ClientBuilder;
//import javax.ws.rs.client.WebTarget;
//import javax.ws.rs.core.MediaType;
//import javax.ws.rs.core.Response;
//import java.io.*;
//import java.net.HttpURLConnection;
//import java.net.URI;
//import java.net.URL;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;

public class StockPriceExtractor {

    private String url = "https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=GOOG&interval=5min&apikey=ERZXXDJN6GDKMCK4";
    ///query
    private static final String API_KEY = "ERZXXDJN6GDKMCK4";

    public StockPriceExtractor() {

    }

    private static final String USER_AGENT = "Mozilla/5.0";

//    public String getResponse(String func, String symbol, int interval) throws IOException {
//
//
//        Client client = ClientBuilder.newClient();
//        WebTarget target = client.target(url);
////        target.queryParam("function", func);
////        target.queryParam("symbol", symbol);
////        target.queryParam("interval", interval+"min");
////        target.queryParam("apikey", API_KEY);
//
//        Response response = target.request(MediaType.APPLICATION_JSON).get();
//        InputStream stream = (InputStream) response.getEntity();
//        BufferedInputStream stream1 = new BufferedInputStream(stream);
//        InputStreamReader reader = new InputStreamReader(stream1);
//        BufferedReader reader1 = new BufferedReader(reader);
//        String line;
//        StringBuilder data = new StringBuilder();
//        while ((line = reader1.readLine()) != null) {
//            data.append(line).append("\n");
//        }
//
//        JsonFactory factory = new JsonFactory();
//        JsonParser parser = factory.createParser(data.toString());
//
//        List<Price> prices = new ArrayList<>();
//
//
//        Price price;
//        while (!parser.isClosed()) {
//            JsonToken jsonToken = parser.nextToken();
//
//            if (JsonToken.FIELD_NAME.equals(jsonToken)) {
//
//                String fieldName = parser.getCurrentName();
//                if (fieldName.startsWith("2020")) {
//
//                    JsonToken priceToken = parser.nextToken();
//                    double open = 0;
//                    double high = 0;
//                    double low = 0;
//                    double close = 0;
//                    int volume = 0;
//                    while (!(priceToken = parser.nextToken()).isStructEnd()) {
//
//
//                        fieldName = parser.getCurrentName();
//                        if (fieldName.equals("1. open")) {
//                            priceToken = parser.nextToken();
//                            open = parser.getValueAsDouble();
//                        }
//                        if (fieldName.equals("2. high")) {
//                            priceToken = parser.nextToken();
//                            high = parser.getValueAsDouble();
//                        }
//                        if (fieldName.equals("3. low")) {
//                            priceToken = parser.nextToken();
//                            low = parser.getValueAsDouble();
//                        }
//
//                        if (fieldName.equals("4. close")) {
//                            priceToken = parser.nextToken();
//                            close = parser.getValueAsDouble();
//                        }
//                        if (fieldName.equals("5. volume")) {
//                            parser.nextToken();
//                            volume = parser.getValueAsInt();
//                        }
//
//
//                    }
//                    price = new Price(high, open, close, volume);
//                    prices.add(price);
//
//
//                }
//
//            }
//        }
//
//        StringBuilder output = new StringBuilder();
//        output.append("Open ").append(" Close ").append(" High ").append("Volume").append("\n");
//        output.append("==========================================================").append("\n");
//        for (Price price1 : prices) {
//            output.append(price1).append("\n");
//        }
//        return output.toString();
//
//
//        //JsonFactory factory = new JsonFactory();
//        // JsonParser parser = factory.createParser(response.readEntity());
//
////        Map<String, List<Object>> map = response.getMetadata();
////        for (String key : map.keySet()) {
////            System.out.println(key + ":");
////            for (Object obj : map.get(key)) {
////                System.out.println(obj);
////            }
////
////        }
//
//
////
////
////        URL obj = new URL(url);
////        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
////
////        //https://www.alphavantage.co/query?function=TIME_SERIES_INTRADAY&symbol=GOOG&interval=5min&apikey=ERZXXDJN6GDKMCK4
//////        // optional default is GET
////        con.setRequestMethod("GET");
////        con.addRequestProperty("function", func);
////        con.addRequestProperty("symbol", symbol);
////        con.addRequestProperty("interval", interval+"min");
////        con.addRequestProperty("apikey", API_KEY);
////        con.setRequestProperty("Accept", "application/json");
//////        con.setRequestMethod("query"); ;
////
////        //add request header
////      //  con.setRequestProperty("User-Agent", USER_AGENT);
////
////       // System.out.println(con.toString());
////
////        int responseCode = con.getResponseCode();
////        System.out.println("\nSending 'GET' request to URL : " + url);
////        System.out.println("Response Code : " + responseCode);
////
////        BufferedReader in = new BufferedReader(
////                new InputStreamReader(con.getInputStream()));
////        String inputLine;
////        StringBuffer response = new StringBuffer();
////
////        while ((inputLine = in.readLine()) != null) {
////            response.append(inputLine);
////        }
////        in.close();
//
//        //print result
//       // System.out.println(response.toString());
//
//    }
//
//    public static void main(String[] args) throws IOException {
//        new StockPriceExtractor().getResponse("TIME_SERIES_INTRADAY", "GOOG", 10);
//    }
}
