package edu.bionic.testdata;

import edu.bionic.domain.Role;
import edu.bionic.domain.User;

public class UserFactory {

    public static User getAdmin() {
        return new User(
                1,
                "admin@mail.com",
                "admin",
                "Administrator",
                Role.ADMIN
        );
    }

    public static User getUser() {
        return new User(
                2,
                "user@mail.com",
                "user",
                "Username",
                Role.USER
        );
    }

    public static User newUser() {
        return new User(
                null,
                "new_user@mail.com",
                "pass",
                "New User",
                Role.USER
        );
    }
}
