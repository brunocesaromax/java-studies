package com.example.GlobalExceptionHandling.dto;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;

@Setter
@Getter
public class ProductDTO {

    @NotEmpty
    @Size(min = 1, max = 50)
    private String name;

    @NotEmpty
    @Size(min = 7, max = 7)
    private String code;

    @NotNull
    private BigDecimal value;

    @NotNull
    @Min(value = 1)
    private Integer quantity;
}
