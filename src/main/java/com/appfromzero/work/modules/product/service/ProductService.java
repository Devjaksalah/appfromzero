package com.appfromzero.work.modules.product.service;


import com.appfromzero.work.modules.product.model.Product;
import com.appfromzero.work.modules.product.repository.ProductRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

@Service
public class ProductService
{
    @Autowired
    ProductRespository productRespository;



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
