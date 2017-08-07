package edu.bionic.dao;

import edu.bionic.domain.Order;
import edu.bionic.domain.Product;

import java.util.List;

public interface OrderDao {

    List<Order> getAll();



    void save(Order order);
}
