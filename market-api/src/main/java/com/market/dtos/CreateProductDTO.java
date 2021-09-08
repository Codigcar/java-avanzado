package com.market.dtos;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
@Getter
@Setter
public class CreateProductDTO {
    private String description;
    private Long stock;
    private Integer status;
    private BigDecimal price;


    private Long categoryId;
}
