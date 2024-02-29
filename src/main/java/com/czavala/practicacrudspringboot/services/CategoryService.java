package com.czavala.practicacrudspringboot.services;

import com.czavala.practicacrudspringboot.dto.CategoryDto;
import com.czavala.practicacrudspringboot.dto.SaveCategoryDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CategoryService {

    Page<CategoryDto> findAll(Pageable pageable);

    Optional<CategoryDto> findOneById(Long id);

    CategoryDto createOne(SaveCategoryDto saveCategoryDto);

    CategoryDto updateOneById(Long id, SaveCategoryDto saveCategoryDto);

    CategoryDto disableOneById(Long id);
}
