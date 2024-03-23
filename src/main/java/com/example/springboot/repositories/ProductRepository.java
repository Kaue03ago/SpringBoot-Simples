package com.example.springboot.repositories;

import com.example.springboot.models.ProductModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository//apenas uma notação para indicar que essa classe é um repositório
public interface ProductRepository extends JpaRepository<ProductModel, UUID> {//o jparepository ja faz o que a linha de cima faria, por isso a linha de cima
    // se torna apenas uma notação

    ProductModel findByName(String name);//método para buscar um produto pelo nome

}
