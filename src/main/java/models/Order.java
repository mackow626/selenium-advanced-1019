package models;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<Product> products;
    private BigDecimal totalOrderPrice;

    public Order() {
        products = new ArrayList<>();
    }

    public Order(List<Product> products, BigDecimal totalOrderPrice) {
        this.products = products;
        this.totalOrderPrice = totalOrderPrice;
    }

    private void updateTotalPrice() {
        totalOrderPrice = new BigDecimal(0);
        for (Product product : products) {
            totalOrderPrice = totalOrderPrice.add(product.getTotalPrice());
        }
    }

    public void addProduct(Product productToAdd) {
        for (Product product : products) {
            if (product.getName().equals(productToAdd.getName())) {
                product.addQuantity(productToAdd.getQuantity());
                updateTotalPrice();
                return;
            }
        }
        products.add(productToAdd);
        updateTotalPrice();
    }

    public int getTotalQuantity() {
        int sum = 0;
        for (Product product : products) {
            sum += product.getQuantity();
        }
        return sum;
    }
}
