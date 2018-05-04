package com.flux.app.springfluxcart.repository;

import com.flux.app.springfluxcart.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReactiveRepositoryProduct extends ReactiveMongoRepository<Product, String>{
}
