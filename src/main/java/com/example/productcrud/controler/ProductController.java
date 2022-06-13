package com.example.productcrud.controler;

import com.example.productcrud.exception.ProductNotFoundException;
import com.example.productcrud.model.dto.ProductDto;
import com.example.productcrud.model.entity.ProductEntity;
import com.example.productcrud.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

import static com.example.productcrud.util.ModelMapperUtil.map;
import static com.example.productcrud.util.ModelMapperUtil.mapAll;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto findOneById(@PathVariable UUID id) throws ProductNotFoundException {
        return map(productService.findByProductId(id), ProductDto.class);
    }

    @GetMapping()
    public List<ProductDto> findAll() {
        return mapAll(productService.findAllProduct(), ProductDto.class);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveProduct(@RequestBody ProductDto productDto) {
        productService.saveProduct(map(productDto, ProductEntity.class));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable UUID id) {
        productService.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateById(@PathVariable UUID id, @RequestBody ProductDto productDto) throws ProductNotFoundException {
        productService.updateProduct(map(productDto, ProductEntity.class), id);
    }

}
