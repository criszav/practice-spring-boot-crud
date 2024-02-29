package com.czavala.practicacrudspringboot.persistance.repositories;

import com.czavala.practicacrudspringboot.persistance.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}
