package com.example.springboot.controllers;

import com.example.springboot.dtos.ProductRecordDto;
import com.example.springboot.models.ProductModel;
import com.example.springboot.repositories.ProductRepository;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController//

public class ProductController {

    @Autowired//injeção de dependência
    ProductRepository productRepository;//instanciando a interface

    //aqui vai os métodos de CRUD
    @PostMapping("/products")
    public ResponseEntity<ProductModel> saveProduct(@RequestBody @Valid ProductRecordDto productRecordDto){
        var productModel = new ProductModel();
        BeanUtils.copyProperties(productRecordDto, productModel);//copia as propriedades de um objeto para outro
        String aux = productModel.getName();

        if(productRepository.findByName(aux) != null){//se o produto já existir
            return ResponseEntity.status(HttpStatus.CONFLICT).body(productRepository.findByName(aux));//retorna o status 409 e o objeto salvo
//             return ResponseEntity.status(HttpStatus.NOT_FOUND).body("aux");//retorna o status 404 e a mensagem

        }

        return ResponseEntity.status(HttpStatus.CREATED).body(productRepository.save(productModel));//retorna o status 201 e o objeto salvo

    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductModel>> getAllProducts(){//retorna uma lista de objetos
        if(productRepository.findAll().isEmpty()){
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//retorna o status 204
        }
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.findAll());//retorna o status 200 e todos os objetos salvos
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Object> getOneProduct(@PathVariable(value="id") UUID id){//retorna um objeto
        Optional<ProductModel> product0 = productRepository.findById(id);//busca o objeto pelo id
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");//retorna o status 404 e a mensagem
        }
        return ResponseEntity.status(HttpStatus.OK).body(product0.get());//retorna o status 200 e o objeto

    }

    @PutMapping("/products/{id}")
    public ResponseEntity<Object> updateProduct(@PathVariable(value="id") UUID id, @RequestBody
                                                @Valid ProductRecordDto productRecordDto){
        Optional<ProductModel> product0 = productRepository.findById(id);//busca NA BASE DE DADOS o objeto pelo id usando o método findById, productRepository é a instância da interface
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");//retorna o status 404 e a mensagem
        }



        var productModel = product0.get();//a variavel rcebe o objeto
        BeanUtils.copyProperties(productRecordDto, productModel);//copia as propriedades de um objeto para outro
        return ResponseEntity.status(HttpStatus.OK).body(productRepository.save(productModel));//retorna o status 200 e o objeto salvo
    }

    @DeleteMapping("/products/{id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable(value="id") UUID id){
        Optional<ProductModel> product0 = productRepository.findById(id);//busca base de dados
        if(product0.isEmpty()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Product not found");
        }
        productRepository.delete(product0.get());//deleta o objeto
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();//retorna o status 204
    }

    @DeleteMapping("/products")
    public ResponseEntity<Object>deletctAllProducts(){
        if(productRepository.findAll().isEmpty()){//se a lista estiver vazia
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Products not found");
        }
        productRepository.deleteAll();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
