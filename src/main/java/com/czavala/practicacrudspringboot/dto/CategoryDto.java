package com.czavala.practicacrudspringboot.dto;

import com.czavala.practicacrudspringboot.persistance.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryDto implements Serializable {

    private String name;

    private Status status;
}
