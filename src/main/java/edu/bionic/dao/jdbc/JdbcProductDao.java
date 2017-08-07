package edu.bionic.dao.jdbc;

import edu.bionic.dao.ProductDao;
import edu.bionic.domain.Color;
import edu.bionic.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@Primary
public class JdbcProductDao implements ProductDao {

    private RowMapper<Product> ROW_MAPPER;


    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcProductDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        ROW_MAPPER = (rs, rowNum) -> {
            Product product = new Product();
            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getBigDecimal("price"));
            product.setColor(Color.values()[rs.getInt("color")]);
            product.setCapacity(rs.getInt("capacity"));
            product.setDisplay(rs.getString("display"));
            product.setDisplay(rs.getString("description"));
            return product;
        };
    }


    @Override
    public List<Product> getAll() {
        String sql = "SELECT * FROM products";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public Optional<Product> getById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        List<Product> product = jdbcTemplate.query(sql, new Object[]{productId}, ROW_MAPPER);
        return Optional.ofNullable(DataAccessUtils.singleResult(product));
    }

    @Override
    public List<Product> getAllProductByOrderId(int orderId) {

        String sql = "SELECT * FROM products " +
                "INNER JOIN orders_products ON orders_products.product_id = products.id " +
                " INNER JOIN orders ON orders.id=orders_products.order_id" +
                " WHERE order_id=" + orderId;
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }
}
