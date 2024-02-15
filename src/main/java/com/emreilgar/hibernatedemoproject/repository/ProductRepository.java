package com.emreilgar.hibernatedemoproject.repository;

import com.emreilgar.hibernatedemoproject.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
}
