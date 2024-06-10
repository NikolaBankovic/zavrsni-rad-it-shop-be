package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.ProductDto;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts();
    void deleteProduct(Long id);
}
