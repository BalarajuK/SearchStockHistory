package com.bala.stocks.service;

import com.bala.stocks.external.stocks.JSonBuilder;
import com.bala.stocks.external.stocks.StockInfoProvider;
import com.bala.stocks.impl.StockData;
import com.bala.stocks.model.TradeDay;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StockHistoryService {


//    @Autowired
//    RestTemplate restTemplate;

    @RequestMapping("/welcome")
    public String index() {
        return new StockData().getWelcomePageData();
        //return "Greetings from Spring Boot!";
    }
//
//    @GET
//    @Path("/trading")
//    @Produces(MediaType.APPLICATION_JSON)
//    public String getTrading(@FormParam("company") String company) {
//        //https://www.alphavantage.co/query?function=TIME_SERIES_DAILY_ADJUSTED&symbol=BSE:IDEA&apikey=XYZ
//        List<TradeDay> idea = new StockInfoProvider().getTrade(company);
//        String jSon = new JSonBuilder().createJSon(idea);
//        System.out.println(jSon);
//        return jSon;
//    }


    @RequestMapping(value = "/search/trading")
    public String getProductList(@RequestParam("company") String company) {
        List<TradeDay> idea = new StockInfoProvider().getTrade(company);
        String jSon = new JSonBuilder().createJSon(idea);
        System.out.println(jSon);
        return jSon;
    }

    @RequestMapping(value = "/trading/search")
    public ResponseEntity<TradeDay> getProduct(@RequestParam("company") String company) {
        return new ResponseEntity<>(new StockInfoProvider().getTrade(company).get(0), HttpStatus.OK);
    }

//    @RequestMapping(value = "/template/products", method = RequestMethod.POST)
//    public String createProducts(@RequestBody TradeDay product) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        HttpEntity<TradeDay> entity = new HttpEntity<TradeDay>(product, headers);
//
//        return restTemplate.exchange(
//                "http://localhost:8080/products", HttpMethod.POST, entity, String.class).getBody();
//    }
}
