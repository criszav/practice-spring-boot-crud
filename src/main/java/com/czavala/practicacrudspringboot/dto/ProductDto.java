package com.czavala.practicacrudspringboot.dto;

import com.czavala.practicacrudspringboot.persistance.enums.Status;

import java.io.Serializable;

public class ProductDto implements Serializable {

    private String name;

    private Integer price;

    private Status status;
}
