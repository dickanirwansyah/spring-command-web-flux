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
        String id = insertProduct.getId();
        boolean valid = false;
        Product product = null;

        if(id == null){
            product = new Product();
            valid = true;
        }

        product.setName(insertProduct.getName());
        product.setDescription(insertProduct.getDescription());
        product.setQuantity(insertProduct.getQuantity());
        product.setPrice(insertProduct.getPrice());
        product.setBrand(insertProduct.getBrand());
        return reactiveRepositoryProduct.save(product);
    }

    @Override
    public Mono<Product> updatedProduct(UpdateProduct updateProduct) {
        return reactiveRepositoryProduct.findById(updateProduct.getId())
                .flatMap(currentData -> {
                    currentData.setId(updateProduct.getId());
                    currentData.setName(updateProduct.getName());
                    currentData.setQuantity(updateProduct.getQuantity());
                    currentData.setPrice(updateProduct.getPrice());
                    currentData.setDescription(updateProduct.getDescription());
                    currentData.setBrand(updateProduct.getBrand());
                    return reactiveRepositoryProduct.save(currentData);
                });
    }

    @Override
    public Mono<Void> deleteProduct(String id) {
        return reactiveRepositoryProduct.findById(id)
                .flatMap(destroyProduct -> {
                    return reactiveRepositoryProduct.delete(destroyProduct);
                });
    }
}
