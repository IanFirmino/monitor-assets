package com.ian.monitorassets.service;

import com.ian.monitorassets.dto.StockResponseDTO;
import com.ian.monitorassets.exception.BusinessException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


@Service
public class IEXCloudService {

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

    public StockResponseDTO getStockQuote(String symbol) {
        String url = createUrlApi(symbol);

        try {
            ResponseEntity<StockResponseDTO> stockResponseDTO = restTemplate.getForEntity(url, StockResponseDTO.class);

            if(stockResponseDTO.getStatusCodeValue() == 200){
                return stockResponseDTO.getBody();
            }else{
                throw new BusinessException("Error getting quote from IEXCloud API");
            }
        }catch(RestClientException ex){
            throw new BusinessException("Error during API call", ex);
        }
    }

}
