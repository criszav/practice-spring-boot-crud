package com.czavala.practicacrudspringboot.mapper;

import com.czavala.practicacrudspringboot.dto.CategoryDto;
import com.czavala.practicacrudspringboot.dto.ProductDto;
import com.czavala.practicacrudspringboot.persistance.entities.Category;
import com.czavala.practicacrudspringboot.persistance.entities.Product;
import org.springframework.stereotype.Service;

@Service
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

    public CategoryDto mapToCategoryDto(Category category) {
        if (category == null) return null;

        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        categoryDto.setStatus(category.getStatus());

        return categoryDto;
    }
}
