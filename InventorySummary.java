
package com.example.productcatalog.model;

public class InventorySummary {
    private int totalProducts;
    private int totalStock;

    public InventorySummary(int totalProducts, int totalStock) {
        this.totalProducts = totalProducts;
        this.totalStock = totalStock;
    }

    public int getTotalProducts() { return totalProducts; }
    public void setTotalProducts(int totalProducts) { this.totalProducts = totalProducts; }
    public int getTotalStock() { return totalStock; }
    public void setTotalStock(int totalStock) { this.totalStock = totalStock; }
}
