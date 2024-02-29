package com.czavala.practicacrudspringboot.services.impl;

import com.czavala.practicacrudspringboot.dto.ProductDto;
import com.czavala.practicacrudspringboot.dto.SaveProductDto;
import com.czavala.practicacrudspringboot.exceptions.ResourceNotFoundException;
import com.czavala.practicacrudspringboot.mapper.Mapper;
import com.czavala.practicacrudspringboot.persistance.entities.Category;
import com.czavala.practicacrudspringboot.persistance.entities.Product;
import com.czavala.practicacrudspringboot.persistance.enums.Status;
import com.czavala.practicacrudspringboot.persistance.repositories.ProductRepository;
import com.czavala.practicacrudspringboot.services.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final Mapper mapper;

    @Override
    public Page<ProductDto> findAllProducts(Pageable pageable) {
        return productRepository.findAll(pageable).map(product -> mapper.mapToProductDto(product));
    }

    @Override
    public Optional<ProductDto> findOneById(Long id) {
        return productRepository.findById(id).map(product -> mapper.mapToProductDto(product));
    }

    @Override
    public ProductDto createOne(SaveProductDto saveProductDto) {
        Product product = new Product();
        product.setName(saveProductDto.getName());
        product.setPrice(saveProductDto.getPrice());
        product.setStatus(Status.ENABLE);

        Category category = new Category();
        category.setId(saveProductDto.getCategoryId());

        product.setCategory(category);
        productRepository.save(product);
        return mapper.mapToProductDto(product);
    }

    @Override
    public ProductDto updateOneById(Long id, SaveProductDto saveProductDto) {
        Product productFromDB = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found. Product id: " + id));
        productFromDB.setName(saveProductDto.getName());
        productFromDB.setPrice(saveProductDto.getPrice());

        Category category = new Category();
        category.setId(saveProductDto.getCategoryId());

        productFromDB.setCategory(category);
        productRepository.save(productFromDB);
        return mapper.mapToProductDto(productFromDB);
    }

    @Override
    public ProductDto disableOneById(Long id) {
        Product productFromDB = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found. Product id: " + id));
        productFromDB.setStatus(Status.DISABLED);
        productRepository.save(productFromDB);
        return mapper.mapToProductDto(productFromDB);
    }
}
