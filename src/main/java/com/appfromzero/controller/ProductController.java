package com.appfromzero.controller;


import com.appfromzero.dto.ProductDTO;
import com.appfromzero.mapper.ProductMapper;
import com.appfromzero.service.ProductService;

import com.appfromzero.model.Product;
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
    public ResponseEntity<ProductDTO> create(@RequestBody ProductDTO productDTO)
    {
        System.out.println(productDTO);
        Product product = productMapper.toProduct(productDTO);
        System.out.println("productMapper = " + productMapper);
        System.out.println(product);
        System.out.println("productService = " + productService);
        productService.save(product);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDTO);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> findById(@PathVariable Long id)
    {
        Optional<Product> product = productService.findById(id);
        ProductDTO productDTO = productMapper.toProductDTO(product.get());
        return ResponseEntity.ok(productDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> update(@PathVariable Long id,	@RequestBody ProductDTO productDTO)
    {
        Product product = productMapper.toProduct(productDTO);
        product.setId(id);

        productService.save(product);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(productDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id)
    {
        productService.deleteById(id);

        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAll()
    {
        List<ProductDTO> productList = productMapper.toProductDTOs(productService.findAll());
        return ResponseEntity.ok(productList);
    }

}

