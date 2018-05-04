package com.flux.app.springfluxcart.model;

import com.flux.app.springfluxcart.entity.Brand;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class InsertProduct {


    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @NotNull
    private int quantity;

    @NotNull
    private int price;

    @NotNull
    private Brand brand;
}
