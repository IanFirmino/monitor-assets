package com.ian.monitorassets.service;

import com.ian.monitorassets.exception.BusinessException;
import com.ian.monitorassets.model.Stock;
import com.ian.monitorassets.respository.StockRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    @Autowired
    private StockRepository stockRepository;

    public Stock addStockToList(Stock stock){
        //Optional<Stock> alreadyExists = stockRepository.findByStock(stock.getStock());
        //if(alreadyExists.isPresent()){
        //    throw new BusinessException("Already listed on the stock list" + alreadyExists.get().getStock());
        //}
        return stockRepository.save(stock);
    }

    public List<Stock> getStockList(){
        return stockRepository.findAll();
    }


}
