package com.flux.app.springfluxcart.controller;

import com.flux.app.springfluxcart.entity.Product;
import com.flux.app.springfluxcart.model.InsertProduct;
import com.flux.app.springfluxcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/product")
public class ControllerProduct {

    @Autowired
    private ProductService productService;

    @GetMapping
    public Flux<Product> listProduct(){
        return productService.listProduct();
    }

    @PostMapping(value = "/created")
    public Mono<ResponseEntity<Product>> createdProduct(@RequestBody @Valid InsertProduct insertProduct){
        return productService.createdProduct(insertProduct)
                .map(callbackJSON -> new ResponseEntity<Product>(callbackJSON, HttpStatus.CREATED))
                .defaultIfEmpty(ResponseEntity.badRequest().build());
    }
}
