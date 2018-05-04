package com.flux.app.springfluxcart.service.implement;

import com.flux.app.springfluxcart.entity.Product;
import com.flux.app.springfluxcart.model.InsertProduct;
import com.flux.app.springfluxcart.model.UpdateProduct;
import com.flux.app.springfluxcart.repository.ReactiveRepositoryProduct;
import com.flux.app.springfluxcart.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class ProductServiceImplement implements ProductService {

    @Autowired
    private ReactiveRepositoryProduct reactiveRepositoryProduct;

    @Override
    public Flux<Product> listProduct() {
        return reactiveRepositoryProduct.findAll();
    }

    @Override
    public Mono<Product> createdProduct(InsertProduct insertProduct) {
        return null;
    }

    @Override
    public Mono<Product> updatedProduct(UpdateProduct updateProduct) {
        return null;
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return null;
    }
}
