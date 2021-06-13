package com.library.service.system.clients.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.FieldNameConstants;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@FieldNameConstants
public class BookDTO extends BaseDTO{
    private String title;
    private String category;
    private BigDecimal price;
    private String author;
    private String publisher;
}
