package com.ian.monitorassets.respository;

import com.ian.monitorassets.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StockRepository extends JpaRepository<Stock, Long> {
    //Optional<Stock> findByStock(String stock);
}
