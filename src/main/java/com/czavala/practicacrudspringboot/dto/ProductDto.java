package com.czavala.practicacrudspringboot.dto;

import com.czavala.practicacrudspringboot.persistance.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto implements Serializable {

    private String name;

    private Integer price;

    private String category;

    private Status status;
}
