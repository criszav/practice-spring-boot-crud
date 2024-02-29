package com.czavala.practicacrudspringboot.dto;

import com.czavala.practicacrudspringboot.persistance.entities.Category;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SaveProductDto implements Serializable {

    @NotBlank(message = "Debe ingresar nombre del producto")
    private String name;

    @Min(value = 1, message = "Debe ingresar un precio mayor o igual a 1")
    private Integer price;

    @Min(value = 1, message = "Debe ingresar una id de categoría válido")
    private Long categoryId;
}
