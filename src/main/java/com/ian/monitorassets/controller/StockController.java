package com.ian.monitorassets.controller;

import com.ian.monitorassets.dto.StockRequestDTO;
import com.ian.monitorassets.dto.StockResponseDTO;
import com.ian.monitorassets.mapper.StockMapper;
import com.ian.monitorassets.model.Stock;
import com.ian.monitorassets.service.IEXCloudService;
import com.ian.monitorassets.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    private final IEXCloudService iexCloudService;
    private final StockService stockService;
    private final StockMapper stockMapper;

    @Autowired
    public StockController(IEXCloudService iexCloudService, StockService stockService, StockMapper stockMapper) {
        this.iexCloudService = iexCloudService;
        this.stockService = stockService;
        this.stockMapper = stockMapper;
    }

    @GetMapping("/{symbol}")
    public ResponseEntity<StockResponseDTO> getStockQuote(@PathVariable String symbol) {
        Stock stock = iexCloudService.getStockQuote(symbol);
        StockResponseDTO stockResponse = stockMapper.stockToResponse(stock);
        return ResponseEntity.status(HttpStatus.OK).body(stockResponse);
    }

    @GetMapping
    public ResponseEntity<List<StockResponseDTO>> getStockQuoteList(){
        List<Stock> stocks = stockService.getStockList();
        List<StockResponseDTO> stocksResponseDTO = stockMapper.mapToStockResponseDTOList(stocks);
        return ResponseEntity.status(HttpStatus.OK).body(stocksResponseDTO);
    }

    @PostMapping
    public ResponseEntity<StockResponseDTO> addStockToList(@RequestBody StockRequestDTO stockRequestDTO){
        Stock stock = stockMapper.requestToStock(stockRequestDTO);
        Stock stockSaved = stockService.addStockToList(stock);
        StockResponseDTO stockResponseDTO = stockMapper.stockToResponse(stockSaved);
        return ResponseEntity.status(HttpStatus.OK).body(stockResponseDTO);
    }

}
