package com.czavala.practicacrudspringboot.persistance.repositories;

import com.czavala.practicacrudspringboot.persistance.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
