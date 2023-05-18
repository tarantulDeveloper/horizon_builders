package com.horizonbuilders.server.service;

import com.horizonbuilders.server.dto.request.ProductRequest;
import com.horizonbuilders.server.dto.request.ProductUpdateRequest;
import com.horizonbuilders.server.model.inventory.Product;
import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

public interface ProductService {
    Product createProduct(ProductRequest request);

    Page<Product> getAllProducts(int pageNo, int pageSize, String sortBy);

    Product getById(int productId);

    void deleteById(int productId);

    Product updateProduct(ProductUpdateRequest request, int id);

    Product updateImg(MultipartFile img, int id);
}
