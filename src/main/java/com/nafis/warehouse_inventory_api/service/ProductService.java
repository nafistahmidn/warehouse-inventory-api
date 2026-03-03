package com.nafis.warehouse_inventory_api.service;

import com.nafis.warehouse_inventory_api.dto.ProductCreateRequest;
import com.nafis.warehouse_inventory_api.dto.ProductResponse;
import com.nafis.warehouse_inventory_api.entity.Product;
import com.nafis.warehouse_inventory_api.exception.DuplicateSkuException;
import com.nafis.warehouse_inventory_api.exception.NotFoundException;
import com.nafis.warehouse_inventory_api.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public ProductResponse create(ProductCreateRequest req) {
        if (repo.existsBySku(req.getSku())) {
            throw new DuplicateSkuException(req.getSku());
        }

        Product p = new Product();
        p.setSku(req.getSku().trim());
        p.setName(req.getName().trim());
        p.setPrice(req.getPrice());
        p.setReorderLevel(req.getReorderLevel());
        p.setActive(true);

        Product saved = repo.save(p);
        return toResponse(saved);
    }

    public Page<ProductResponse> list(Pageable pageable) {
        return repo.findAll(pageable).map(this::toResponse);
    }

    public ProductResponse getById(Long id) {
        Product p = repo.findById(id).orElseThrow(() -> new NotFoundException("Product not found: " + id));
        return toResponse(p);
    }

    private ProductResponse toResponse(Product p) {
        return new ProductResponse(
                p.getId(),
                p.getSku(),
                p.getName(),
                p.getPrice(),
                p.getReorderLevel(),
                p.getActive()
        );
    }
}