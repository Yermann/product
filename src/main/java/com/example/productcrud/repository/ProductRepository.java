package com.example.productcrud.repository;

import com.example.productcrud.model.entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,UUID> {

    @Override
    Optional<ProductEntity> findById(UUID uuid);

    @Override
    List<ProductEntity> findAll();

}
