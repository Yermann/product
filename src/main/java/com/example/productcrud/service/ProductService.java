package com.example.productcrud.service;

import com.example.productcrud.exception.ProductNotFoundException;
import com.example.productcrud.exception.ErrorCode;
import com.example.productcrud.model.entity.ProductEntity;
import com.example.productcrud.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public List<ProductEntity> findAllProduct() {
        return repository.findAll();
    }

    public ProductEntity findByProductId(UUID id) throws ProductNotFoundException {
        return repository.findById(id).orElseThrow(
                () -> new ProductNotFoundException(ErrorCode.PRODUCT_ID_NOT_FOUND));
    }

    public void deleteById(UUID id) {
        repository.deleteById(id);
    }

    public void updateProduct(ProductEntity product, UUID id) throws ProductNotFoundException {
        var productEntity = findByProductId(id);
        productEntity.setName(product.getName());
        productEntity.setDate(product.getDate());
        productEntity.setPrice(product.getPrice());
        repository.save(productEntity);
    }

    public void saveProduct(ProductEntity product) {
        repository.save(product);
    }
}
