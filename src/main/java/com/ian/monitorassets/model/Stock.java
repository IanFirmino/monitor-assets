package com.ian.monitorassets.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity(name = "Stock")
@Table(name = "Stock")
@Getter
@Setter
public class Stock {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String symbol;
    private Double iexRealtimePrice;

}
