package com.nafis.warehouse_inventory_api.controller;

import com.nafis.warehouse_inventory_api.dto.ProductCreateRequest;
import com.nafis.warehouse_inventory_api.dto.ProductResponse;
import com.nafis.warehouse_inventory_api.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ProductResponse create(@Valid @RequestBody ProductCreateRequest req) {
        return service.create(req);
    }

    @GetMapping
    public Page<ProductResponse> list(Pageable pageable) {
        return service.list(pageable);
    }

    @GetMapping("/{id}")
    public ProductResponse getOne(@PathVariable Long id) {
        return service.getById(id);
    }
}