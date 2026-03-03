package com.nafis.warehouse_inventory_api.exception;

public class DuplicateSkuException extends RuntimeException {
    public DuplicateSkuException(String sku) {
        super("SKU already exists: " + sku);
    }
}