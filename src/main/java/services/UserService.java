package services;

import models.User;
import repository.UserDAO;
import repository.UserDAOImpl;

public class UserService {
     private UserDAO userDAO;

     public UserService(UserDAO userDAO){
         this.userDAO = userDAO;
     }

     public UserService(){
         this.userDAO = new UserDAOImpl();
     }

     public User validateCredentials(String username, String password){
         User user = this.userDAO.getUserByUsername(username);

         if(user == null)
             return null;


         if(!password.equals(user.getPassword()))
             return null;

         return user;
     }

    public Boolean createUser(User user){
        //get user from db
        User userFromDb = userDAO.getUserByUsername(user.getUsername());
        //User userFromDb = getUserByUsername(user.getUsername());
        if(userFromDb != null){
            return Boolean.FALSE;
        }

        this.userDAO.createUser(user);
        return Boolean.TRUE;
    }

    /*public User getUserByUsername(String username){
        User userFromDb = userDAO.getUserByUsername(username);
        return userFromDb;
    }*/

}
