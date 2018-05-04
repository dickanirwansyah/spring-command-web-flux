package com.flux.app.springfluxcart.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;

@Data
@Getter
@Setter
@Document(collection = "brand")
public class Brand {

    @Id
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;
}
