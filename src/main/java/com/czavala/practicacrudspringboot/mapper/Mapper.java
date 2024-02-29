package com.czavala.practicacrudspringboot.mapper;

import com.czavala.practicacrudspringboot.dto.ProductDto;
import com.czavala.practicacrudspringboot.dto.SaveProductDto;
import com.czavala.practicacrudspringboot.persistance.entities.Product;

public class Mapper {


    public ProductDto mapToProductDto(Product product) {
        if (product == null) return null;

        ProductDto productDto = new ProductDto();
        productDto.setName(product.getName());
        productDto.setPrice(product.getPrice());
        productDto.setStatus(product.getStatus());
        productDto.setCategory(product.getCategory().getName());

        return productDto;
    }
}
