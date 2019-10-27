package models;

import java.math.BigDecimal;

public class Product {
    private String name;
    private BigDecimal price;
    private int quantity;
    private BigDecimal totalPrice;

    public int getQuantity() {
        return quantity;
    }


    public BigDecimal getTotalPrice() {
        return totalPrice;
    }


    public Product(String name, BigDecimal price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        updatePrice();
    }

    public Product(String name, BigDecimal price, int quantity, BigDecimal totalPrice) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }

    public void addQuantity(int quantity) {
        this.quantity += quantity;
        updatePrice();
    }

    private void updatePrice() {
        totalPrice = price.multiply(new BigDecimal(quantity));
    }


    public String getName() {
        return name;
    }
}
