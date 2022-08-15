package com.appfromzero.work.modules.product.controller;


import com.appfromzero.work.modules.product.dto.ProductResponse;
import com.appfromzero.work.modules.product.mapper.ProductMapper;
import com.appfromzero.work.modules.product.model.Product;
import com.appfromzero.work.modules.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController
{
    @Autowired
    ProductService productService;
    @Autowired
    ProductMapper productMapper;

    @PostMapping
    public ResponseEntity<ProductResponse> create(@RequestBody ProductResponse productResponse)
    {
        System.out.println(productResponse);
        Product product = productMapper.toProduct(productResponse);
        System.out.println("productMapper = " + productMapper);
        System.out.println(product);
        System.out.println("productService = " + productService);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productResponse);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> findById(@PathVariable Long id)
    {
        Optional<Product> product = productService.findById(id);
        ProductResponse productResponse = productMapper.toProductDTO(product.get());
        return ResponseEntity.ok(productResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductResponse> update(@PathVariable Long id, @RequestBody ProductResponse productResponse)
    {
        Product product = productMapper.toProduct(productResponse);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductResponse>> findAll()
    {
        List<ProductResponse> productList = productMapper.toProductDTOs(productService.findAll());
        return ResponseEntity.ok(productList);
    }

}

