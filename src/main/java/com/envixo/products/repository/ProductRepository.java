package com.envixo.products.repository;

import com.envixo.products.enums.Status;
import com.envixo.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    public List<Product> findByStatus(Status status);
}
