package com.czavala.practicacrudspringboot.controllers;

import com.czavala.practicacrudspringboot.dto.ProductDto;
import com.czavala.practicacrudspringboot.dto.SaveProductDto;
import com.czavala.practicacrudspringboot.services.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public ResponseEntity<Page<ProductDto>> findAllProducts(Pageable pageable) {
        Page<ProductDto> products = productService.findAllProducts(pageable);
        if (products.hasContent()) {
            return ResponseEntity.ok(products);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDto> findOneById(@PathVariable Long id) {
        Optional<ProductDto> productDto = productService.findOneById(id);
        return productDto.map(productFound -> ResponseEntity.ok(productFound)).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDto> createOne(@RequestBody @Valid SaveProductDto saveProductDto) {
        ProductDto productDto = productService.createOne(saveProductDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDto> updateOneById(@PathVariable Long id, @RequestBody @Valid SaveProductDto saveProductDto) {
        ProductDto productDto = productService.updateOneById(id, saveProductDto);
        return ResponseEntity.status(HttpStatus.OK).body(productDto);
    }

    @PutMapping("/{id}/disable")
    public ResponseEntity<ProductDto> disableOneById(@PathVariable Long id) {
        ProductDto productDto = productService.disableOneById(id);
        return ResponseEntity.ok(productDto);
    }
}
