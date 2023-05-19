package com.horizonbuilders.server.controller;

import com.horizonbuilders.server.dto.request.ProductImgUpdateRequest;
import com.horizonbuilders.server.dto.request.ProductRequest;
import com.horizonbuilders.server.dto.request.ProductUpdateRequest;
import com.horizonbuilders.server.model.inventory.Product;
import com.horizonbuilders.server.service.ProductService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequestMapping("/api/product")
public class ProductController {
    final ProductService productService;

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product addProduct(@ModelAttribute ProductRequest request) {
        return productService.createProduct(request);
    }

    @GetMapping
    public Page<Product> getAllProducts(
            @RequestParam(defaultValue = "0") int pageNo,
            @RequestParam(defaultValue = "3") int pageSize,
            @RequestParam(defaultValue = "id") String sortBy
    ) {
        return productService.getAllProducts(pageNo, pageSize, sortBy);
    }

    @GetMapping("/{productId}")
    public Product getProductById(@PathVariable("productId") int productId) {
        return productService.getById(productId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @DeleteMapping("/{productId}")
    public void deleteById(@PathVariable("productId") int productId) {
        productService.deleteById(productId);
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping
    public Product updateProduct(@RequestBody ProductUpdateRequest request) {
        return productService.updateProduct(request, request.id());
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PutMapping(value = "/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Product updateProductImg(@ModelAttribute ProductImgUpdateRequest request) {
        return productService.updateImg(request.img(), request.productId());
    }
}
