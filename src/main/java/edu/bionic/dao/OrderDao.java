package edu.bionic.dao;

import edu.bionic.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 05.07.17.
 */
public interface OrderDao {
    List<Product> getAll();

    Optional<Product> getById(int productId);
}
