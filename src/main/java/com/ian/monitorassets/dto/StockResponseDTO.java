package com.ian.monitorassets.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StockResponseDTO {

    private String symbol;
    private Double iexRealtimePrice;

}
