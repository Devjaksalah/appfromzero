package com.appfromzero.repository;

import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;



public interface ProductRespository extends JpaRepository<Product, Long> {
}
