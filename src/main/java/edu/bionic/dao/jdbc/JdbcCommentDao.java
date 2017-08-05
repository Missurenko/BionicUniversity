package edu.bionic.dao.jdbc;

import edu.bionic.dao.CommentDao;
import edu.bionic.domain.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by bm on 05.08.17.
 */
@Repository
@Primary
public class JdbcCommentDao implements CommentDao {

    private RowMapper<Comment> ROW_MAPPER;

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public JdbcCommentDao(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;

        ROW_MAPPER = (rs, rowNum) -> {
            Comment comment = new Comment();
            comment.setAuthor(rs.getString("author"));
            comment.setDateTime(rs.getTimestamp("datetime").toLocalDateTime());
            comment.setProductId(rs.getInt("id_product"));
            comment.setText(rs.getString("text"));
            comment.setRating(rs.getInt("rating"));
            return comment;
        };
    }

    @Override
    public List<Comment> getByProduct(int productId) {
        String sql = "SELECT * FROM comments WHERE id_product = " + productId;
        return jdbcTemplate.query(sql, ROW_MAPPER);
    }

    @Override
    public void save(Comment comment) {
        Timestamp timestamp = Timestamp.valueOf(comment.getDateTime());

        jdbcTemplate.update("INSERT INTO comments (" +
                        " id_product,author,datetime,text,rating) VALUES (?,?,?,?,?)",
                comment.getProductId(),
                comment.getAuthor(),
                timestamp,
                comment.getText(),
                comment.getRating());

    }
}
