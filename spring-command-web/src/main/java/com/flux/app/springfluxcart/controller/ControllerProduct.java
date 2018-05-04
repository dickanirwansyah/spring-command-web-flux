package com.flux.app.springfluxcart.controller;

import com.flux.app.springfluxcart.entity.Product;
import com.flux.app.springfluxcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> listProduct(){
        return productService.listProduct();
    }
}
