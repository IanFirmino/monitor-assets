package com.ian.monitorassets.service;

import com.ian.monitorassets.exception.BusinessException;
import com.ian.monitorassets.model.Stock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@Service
public class IEXCloudService {

    @Autowired
    private final RestTemplate restTemplate;
    private final String apiUrl;
    private final String apiKey;

    public IEXCloudService(RestTemplate restTemplate, @Value("${iexcloud.api.key}") String apiKey) {
        this.restTemplate = restTemplate;
        this.apiUrl = "https://cloud.iexapis.com/stable/stock/";
        this.apiKey = apiKey;
    }

    public String createUrlApi(String symbol){
        return apiUrl + symbol + "/quote?token=" + apiKey;
    }

    public Stock getStockQuote(String symbol) {
        String url = createUrlApi(symbol);
        try {
            ResponseEntity<Stock> stock = restTemplate.getForEntity(url, Stock.class);
            if(stock.getStatusCodeValue() == 200){
                return stock.getBody();
            }else{
                throw new BusinessException("Error getting quote from IEXCloud API");
            }
        }catch(RestClientException ex){
            throw new BusinessException("Error during API call", ex);
        }
    }

    //otimizar para uma unica chamada na API
    public List<Stock> getStockQuoteList(List<String> symbols) {
        List<Stock> stocks = new ArrayList<>();
        for (String symbol : symbols) {
            Stock stock = getStockQuote(symbol);
            stocks.add(stock);
        }
        return stocks;
    }




}
