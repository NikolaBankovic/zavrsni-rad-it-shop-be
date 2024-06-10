package hr.fer.zavrsni1500.itshop.service;

import hr.fer.zavrsni1500.itshop.dto.ProductDto;
import hr.fer.zavrsni1500.itshop.dto.filter.ProductFilter;

import java.util.List;

public interface ProductService {

    ProductDto getProductById(Long id);
    List<ProductDto> getAllProducts(ProductFilter filter);
    void deleteProduct(Long id);
    void incrementTimesVisitedForProduct(Long id);
}
