package edu.bionic.service.impl;

import edu.bionic.Product;
import edu.bionic.dao.ProductDao;
import edu.bionic.service.ProductService;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bm on 05.07.17.
 */
public class ProductServiceImpl implements ProductService {

    private ProductDao productDao;


    public ProductServiceImpl(ProductDao productDao) {
        this.productDao = productDao;
    }

    @Override
    public List<Product> getAll() {
        return productDao.getAll()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(int productId) {
        return productDao.getById(productId).
                orElseThrow(() -> new RuntimeException(String.format("Product with id=%d was not found", productId)));
    }
}


