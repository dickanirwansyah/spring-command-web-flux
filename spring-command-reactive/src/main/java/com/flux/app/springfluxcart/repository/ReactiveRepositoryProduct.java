package com.flux.app.springfluxcart.repository;

import com.flux.app.springfluxcart.entity.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ReactiveRepositoryProduct extends ReactiveMongoRepository<Product, String>{

    Flux<Product> findByName(Mono<String> name);
}
