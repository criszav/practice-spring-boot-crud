package com.czavala.practicacrudspringboot.services;

import com.czavala.practicacrudspringboot.dto.ProductDto;
import com.czavala.practicacrudspringboot.dto.SaveProductDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface ProductService {

    Page<ProductDto> findAllProducts(Pageable pageable);

    Optional<ProductDto> findOneById(Long id);

    ProductDto createOne(SaveProductDto saveProductDto);

    ProductDto updateOneById(Long id, SaveProductDto saveProductDto);

    ProductDto disableOneById(Long id);
}
