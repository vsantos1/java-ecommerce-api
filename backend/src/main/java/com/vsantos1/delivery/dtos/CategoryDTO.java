package com.vsantos1.delivery.dtos;

import jakarta.validation.constraints.NotNull;

public class CategoryDTO {

    @NotNull
    private String name;

    public String getName() {
        return name;
    }


}
