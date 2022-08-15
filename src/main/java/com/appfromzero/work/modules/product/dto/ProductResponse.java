package com.appfromzero.work.modules.product.dto;

import lombok.Data;


import java.math.BigDecimal;

@Data
public class ProductResponse
{
    private Integer id;
    private String name;
    private String description;
    private BigDecimal price;
}
