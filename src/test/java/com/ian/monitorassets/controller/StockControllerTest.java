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

}
