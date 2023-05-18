package com.horizonbuilders.server.service.impl;

import com.horizonbuilders.server.dto.request.ProductRequest;
import com.horizonbuilders.server.dto.request.ProductUpdateRequest;
import com.horizonbuilders.server.exception.AlreadyExistException;
import com.horizonbuilders.server.exception.BadRequestException;
import com.horizonbuilders.server.exception.ResourceNotFoundException;
import com.horizonbuilders.server.model.inventory.Product;
import com.horizonbuilders.server.repository.ProductRepository;
import com.horizonbuilders.server.service.CloudinaryService;
import com.horizonbuilders.server.service.ProductService;
import com.horizonbuilders.server.service.SubTypeService;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {
    final ProductRepository productRepository;
    final CloudinaryService cloudinaryService;
    final SubTypeService subTypeService;

    @Override
    public Product createProduct(ProductRequest request) {
        if (productRepository.existsByName(request.name())) {
            throw new AlreadyExistException("Product already exists!");
        }
        if (request.price() < 0 || request.quantity() < 0) {
            throw new BadRequestException("Price or quantity should be more than 0!");
        }
        Product product = Product.builder()
                .name(request.name())
                .quantity(request.quantity())
                .imgUrl(cloudinaryService.upload(request.img()))
                .price(request.price())
                .subType(subTypeService.getById(request.subTypeId()))
                .build();
        productRepository.save(product);
        return product;
    }

    @Override
    public Page<Product> getAllProducts(int pageNo, int pageSize, String sortBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(sortBy).descending());
        return productRepository.findAll(pageable);
    }

    @Override
    public Product getById(int productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
    }

    @Override
    public void deleteById(int productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        productRepository.deleteById(productId);
    }

    @Override
    public Product updateProduct(ProductUpdateRequest request, int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        if (productRepository.existsByName(request.name())) {
            throw new AlreadyExistException("Product already exists!");
        }
        if (request.price() < 0 || request.quantity() < 0) {
            throw new BadRequestException("Price or quantity should be more than 0!");
        }
        product.setName(request.name());
        product.setQuantity(request.quantity());
        product.setPrice(request.price());
        product.setSubType(subTypeService.getById(request.subTypeId()));
        return productRepository.save(product);
    }

    @Override
    public Product updateImg(MultipartFile img, int id) {
        Product product = productRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        product.setImgUrl(cloudinaryService.upload(img));
        return productRepository.save(product);
    }


}
