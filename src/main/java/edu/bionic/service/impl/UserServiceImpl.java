package edu.bionic.service.impl;

import edu.bionic.dao.UserDao;
import edu.bionic.domain.Role;
import edu.bionic.domain.User;
import edu.bionic.service.UserService;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;


    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User registerNewUser(User user) {
        user.setRole(Role.USER);
        return userDao.save(user);
    }
}
