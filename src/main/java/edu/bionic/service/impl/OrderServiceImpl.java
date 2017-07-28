package edu.bionic.service.impl;

import edu.bionic.dao.OrderDao;
import edu.bionic.domain.Order;
import edu.bionic.domain.Product;
import edu.bionic.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao;

    @Autowired
    public OrderServiceImpl(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public List<Order> getAll() {
        return orderDao.getAll();
    }

    @Override
    public void createNewOrder(List<Product> products) {
        Order order = new Order(LocalDateTime.now(),
                products.stream().map(Product::getPrice).reduce(BigDecimal::add).orElse(BigDecimal.ZERO),
                products);
        orderDao.save(order);
    }
}
