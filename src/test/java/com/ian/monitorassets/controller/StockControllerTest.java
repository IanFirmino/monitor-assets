package com.ian.monitorassets.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ian.monitorassets.dto.StockResponseDTO;
import com.ian.monitorassets.mapper.StockMapper;
import com.ian.monitorassets.service.IEXCloudService;
import com.ian.monitorassets.service.StockService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StockControllerTest {

    @Mock
    private IEXCloudService iexCloudService;

    @Mock
    private StockService stockService;

    @Mock
    private StockMapper stockMapper;

    @InjectMocks
    private StockController stockController;

    @Test
    public void testGetStockQuote() throws JsonProcessingException {
        String symbol = "MSFT";
        StockResponseDTO mockResponseDTO = new StockResponseDTO();

        when(iexCloudService.getStockQuote(symbol)).thenReturn(mockResponseDTO);
        ResponseEntity<StockResponseDTO> response = stockController.getStockQuote(symbol);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(mockResponseDTO, response.getBody());

        ObjectMapper objectMapper = new ObjectMapper();
        String jsonResponse = objectMapper.writeValueAsString(response.getBody());
        System.out.println("JSON Resultante: " + jsonResponse);
    }

}
