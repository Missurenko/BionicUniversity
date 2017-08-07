package edu.bionic.dao.jdbc;


import edu.bionic.dao.OrderDao;
import edu.bionic.domain.Order;
import edu.bionic.domain.Product;
import edu.bionic.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by bm on 05.08.17.
 */
@Repository
@Primary
public class JdbcOrderDao implements OrderDao {

    private RowMapper<Order> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;

    private ProductService productService;

    @Autowired
    public JdbcOrderDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        ROW_MAPPER = ((rs, rowNum) -> {
            Order order = new Order();
            order.setTotalAmount(rs.getBigDecimal("total_amount"));
            order.setName(rs.getString("name"));
            order.setEmail(rs.getString("email"));
            order.setPhone(rs.getString("phone"));
            order.setAddress(rs.getString("address"));
            order.setDateTime(rs.getTimestamp("date_time").toLocalDateTime());

            return order;
        });
    }

    @Override
    public List<Order> getAll() {
        String sql = "SELECT * FROM orders";
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public void save(Order order) {



        jdbcTemplate.update("INSERT INTO orders (" +
                        " total_amount,name,email,phone,address,date_time) VALUES (?,?,?,?,?,?)",
                order.getTotalAmount(),
                order.getName(),
                order.getEmail(),
                order.getPhone(),
                order.getAddress(),
                Timestamp.valueOf(order.getDateTime()));

    }
}
