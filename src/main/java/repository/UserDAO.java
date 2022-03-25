package repository;

import models.User;

public interface UserDAO {

    User getUserByUsername(String username);
    void createUser(User user);

}
