package edu.bionic.service.impl;

import edu.bionic.dao.ProductDao;
import edu.bionic.dao.jdbc.JdbcProductDao;
import edu.bionic.domain.Product;
import edu.bionic.service.ProductService;
import edu.bionic.util.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {



    private JdbcProductDao jdbcProductDao;

    public ProductServiceImpl(JdbcProductDao jdbcProductDao) {
        this.jdbcProductDao = jdbcProductDao;
    }

    @Override
    public List<Product> getAll() {
        return jdbcProductDao.getAll()
                .stream()
                .sorted(Comparator.comparing(Product::getName))
                .collect(Collectors.toList());
    }

    @Override
    public Product getById(int productId) {
        return jdbcProductDao.getById(productId).
                orElseThrow(() -> new NotFoundException(String.format("Продукт с id=%d не найден", productId)));
    }
}
