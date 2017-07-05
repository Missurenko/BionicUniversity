package edu.bionic.dao.mock;

import edu.bionic.Product;
import edu.bionic.dao.ProductDao;

import java.util.List;
import java.util.Optional;

/**
 * Created by bm on 05.07.17.
 */
public class OrderDaoMock implements ProductDao {
    private List<Product> productStorage;


    @Override
    public List<Product> getAll() {
        return null;
    }

    @Override
    public Optional<Product> getById(int productId) {
        return null;
    }
}
