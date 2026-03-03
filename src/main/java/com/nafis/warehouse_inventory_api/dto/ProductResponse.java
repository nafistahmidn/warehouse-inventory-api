package com.nafis.warehouse_inventory_api.dto;

import java.math.BigDecimal;

public class ProductResponse {
    private Long id;
    private String sku;
    private String name;
    private BigDecimal price;
    private Integer reorderLevel;
    private Boolean active;

    public ProductResponse(Long id, String sku, String name, BigDecimal price, Integer reorderLevel, Boolean active) {
        this.id = id;
        this.sku = sku;
        this.name = name;
        this.price = price;
        this.reorderLevel = reorderLevel;
        this.active = active;
    }

    public Long getId() { return id; }
    public String getSku() { return sku; }
    public String getName() { return name; }
    public BigDecimal getPrice() { return price; }
    public Integer getReorderLevel() { return reorderLevel; }
    public Boolean getActive() { return active; }
}