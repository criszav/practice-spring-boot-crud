package com.czavala.practicacrudspringboot.services.impl;

import com.czavala.practicacrudspringboot.dto.CategoryDto;
import com.czavala.practicacrudspringboot.dto.SaveCategoryDto;
import com.czavala.practicacrudspringboot.exceptions.ResourceNotFoundException;
import com.czavala.practicacrudspringboot.mapper.Mapper;
import com.czavala.practicacrudspringboot.persistance.entities.Category;
import com.czavala.practicacrudspringboot.persistance.enums.Status;
import com.czavala.practicacrudspringboot.persistance.repositories.CategoryRepository;
import com.czavala.practicacrudspringboot.services.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    private final CategoryRepository categoryRepository;
    private final Mapper mapper;

    @Override
    public Page<CategoryDto> findAll(Pageable pageable) {
        return categoryRepository.findAll(pageable).map(category -> mapper.mapToCategoryDto(category));
    }

    @Override
    public Optional<CategoryDto> findOneById(Long id) {
        return categoryRepository.findById(id).map(category -> mapper.mapToCategoryDto(category));
    }

    @Override
    public CategoryDto createOne(SaveCategoryDto saveCategoryDto) {
        Category category = new Category();
        category.setName(saveCategoryDto.getName());
        category.setStatus(Status.ENABLE);
        categoryRepository.save(category);
        return mapper.mapToCategoryDto(category);
    }

    @Override
    public CategoryDto updateOneById(Long id, SaveCategoryDto saveCategoryDto) {
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found. Category id: " + id));
        categoryFromDB.setName(saveCategoryDto.getName());
        categoryRepository.save(categoryFromDB);
        return mapper.mapToCategoryDto(categoryFromDB);
    }

    @Override
    public CategoryDto disableOneById(Long id) {
        Category categoryFromDB = categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found. Category id: " + id));
        categoryFromDB.setStatus(Status.DISABLED);
        categoryRepository.save(categoryFromDB);
        return mapper.mapToCategoryDto(categoryFromDB);
    }
}
