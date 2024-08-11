package hr.fer.zavrsni1500.itshop.controller;

import hr.fer.zavrsni1500.itshop.dto.ProductDto;
import hr.fer.zavrsni1500.itshop.dto.filter.ProductFilter;
import hr.fer.zavrsni1500.itshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:4200")
public class ProductController {

    private final ProductService productService;

    @GetMapping("/{id}")
    public ProductDto getProductById(@PathVariable final Long id) {
        return productService.getProductById(id);
    }

    @GetMapping("/all")
    public List<ProductDto> getAllProducts(final ProductFilter filter) {
        return productService.getAllProducts(filter);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public void deleteProduct(@PathVariable final Long id) {
        productService.deleteProduct(id);
    }

    @PatchMapping("/{id}")
    @CrossOrigin("http://localhost:4200/product/")
    public void incrementTimesVisitedForProduct(@PathVariable final Long id) {
        productService.incrementTimesVisitedForProduct(id);
    }
}
