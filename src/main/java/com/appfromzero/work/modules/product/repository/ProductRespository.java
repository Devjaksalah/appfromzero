package com.appfromzero.work.modules.product.repository;


import com.appfromzero.work.modules.product.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ProductRespository extends JpaRepository<Product, Long> {
}
