package com.bala.stocks.external.stocks;



import com.bala.stocks.model.TradeDay;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;

import java.util.List;
import java.util.Scanner;

public class StockInfoProvider implements IStockInfoProvider {

    @Override
    public String getStockInfo(String company) {

        try {
            String urlPrefix = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=BSE:";
            String urlend = "&apikey=XYZ";

            HttpURLConnection connection = (HttpURLConnection) new URL(urlPrefix+company+urlend).openConnection();

            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if(responseCode == 200){
                String response = "";
                Scanner scanner = new Scanner(connection.getInputStream());
                while(scanner.hasNextLine()){
                    response += convert(scanner.nextLine());
                    response += "\n";
                }
                scanner.close();

                return response;
            }
        }
        catch (ProtocolException ex){
            ex.printStackTrace();
        }
        catch (IOException ex){
            ex.printStackTrace();
        }



        // an error happened
        return null;
    }

    private String convert(String s) {

        String[] pattern = new String[]{"1. open",
                "2. high",
                "3. low",
                "4. close",
                "5. adjusted close",
                "6. volume",
                "7. dividend amount",
                "8. split coefficient"};

        for(String str : pattern){
            if(s.contains(str)){
                return s.substring(0,s.indexOf(str))+s.substring(s.indexOf(str)+3);
            }
        }

        return s;
    }

    @Override
    public List<TradeDay> getTrade(String company) {
        String stockInfo = getStockInfo(company);
      //  System.out.println(stockInfo);
        return new JSonParser().getTrading(stockInfo);
    }
}
