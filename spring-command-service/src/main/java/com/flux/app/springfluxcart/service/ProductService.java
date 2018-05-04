package com.flux.app.springfluxcart.service;

import com.flux.app.springfluxcart.entity.Product;
import com.flux.app.springfluxcart.model.InsertProduct;
import com.flux.app.springfluxcart.model.UpdateProduct;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

    Flux<Product> listProduct();
    Mono<Product> createdProduct(InsertProduct insertProduct);
    Mono<Product> updatedProduct(UpdateProduct updateProduct);
    Mono<Void> deleteProduct(String id);
}
