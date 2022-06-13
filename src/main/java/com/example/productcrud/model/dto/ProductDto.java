package com.example.productcrud.model.dto;

import lombok.Data;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Data
public class ProductDto {

    private UUID id;
    private String name;
    private BigDecimal price;
    private LocalDate date;
}
