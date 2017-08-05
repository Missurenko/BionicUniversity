package edu.bionic.service.impl;

import edu.bionic.dao.CommentDao;
import edu.bionic.dao.jdbc.JdbcCommentDao;
import edu.bionic.domain.Comment;
import edu.bionic.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private JdbcCommentDao jdbcCommentDao;

    @Autowired
    public CommentServiceImpl(JdbcCommentDao jdbcCommentDao) {
        this.jdbcCommentDao = jdbcCommentDao;
    }

    @Override
    public List<Comment> getByProduct(int productId) {
        return jdbcCommentDao.getByProduct(productId);
    }

    @Override
    public void createNew(Comment comment) {
        comment.setDateTime(LocalDateTime.now());
        jdbcCommentDao.save(comment);
    }
}
