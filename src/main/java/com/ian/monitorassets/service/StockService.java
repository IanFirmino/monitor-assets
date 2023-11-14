package com.ian.monitorassets.service;

import com.ian.monitorassets.dto.StockResponseDTO;
import com.ian.monitorassets.model.Stock;
import com.ian.monitorassets.respository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;
import java.util.List;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;
    private IEXCloudService iexCloudService ;

    public Stock addStockToList(Stock stock){
        return stockRepository.save(stock);
    }

    public List<Stock> getStockList(){
        List <Stock> allStock = stockRepository.findAll();
        List <String> symbols = allStock.stream()
                .map(Stock::getSymbol)
                .collect(Collectors.toList());

        return iexCloudService.getStockQuoteList(symbols);
    }


}
