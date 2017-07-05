package edu.bionic;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Created by bm on 05.07.17.
 */
public class Order {


    private LocalDateTime time;
    private BigDecimal totalAmount;
    private List<Product> productList;

    public Order(LocalDateTime time, BigDecimal totalAmount, List<Product> productList) {
        this.time = time;
        this.totalAmount = totalAmount;
        this.productList = productList;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }
}
