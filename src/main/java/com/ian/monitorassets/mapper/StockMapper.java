package com.ian.monitorassets.mapper;

import com.ian.monitorassets.dto.StockRequestDTO;
import com.ian.monitorassets.dto.StockResponseDTO;
import com.ian.monitorassets.model.Stock;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class StockMapper {

    public Stock requestToStock(StockRequestDTO stockRequestDTO){
        Stock stock = new Stock();
        stock.setSymbol(stockRequestDTO.getSymbol());
        stock.setIexRealtimePrice(stockRequestDTO.getIexRealtimePrice());
        return stock;
    }

    public StockResponseDTO stockToResponse(Stock stock){
        StockResponseDTO stockResponseDTO = new StockResponseDTO();
        stockResponseDTO.setSymbol(stock.getSymbol());
        stockResponseDTO.setIexRealtimePrice(stock.getIexRealtimePrice());
        return stockResponseDTO;
    }

    public List<StockResponseDTO> mapToStockResponseDTOList(List<Stock> stockList) {
        return stockList.stream()
                .map(this::stockToResponse)
                .collect(Collectors.toList());
    }

}
