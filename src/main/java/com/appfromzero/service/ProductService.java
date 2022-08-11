package com.appfromzero.service;


import com.appfromzero.repository.ProductRespository;

import lombok.RequiredArgsConstructor;
import model.Product;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ProductService
{
    private final ProductRespository productRespository;

    public List<Product> findAll()
    {
        return productRespository.findAll();
    }

    public Optional<Product> findById(Long id)
    {
        return productRespository.findById(id);
    }

    public Product save(Product product)
    {
        return productRespository.save(product);
    }

    public void deleteById(Long id)
    {
        productRespository.deleteById(id);
    }
}
