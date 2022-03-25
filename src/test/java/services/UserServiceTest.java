package services;

import models.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import repository.UserDAO;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserServiceTest {
    private UserService userService;
    private UserDAO userDAO = Mockito.mock(UserDAO.class);

    private UserServiceTest() {
        this.userService = new UserService(Mockito.mock(UserDAO.class));
    }

    @Test
    void validateCredentialsInvalidUsername() {
        //arrange
        String expectedUsername = "incorrectUsername";
        String expectedPassword = "pass123";
        User expectedOutput = null;
        Mockito.when(userDAO.getUserByUsername(expectedUsername)).thenReturn(expectedOutput);

        //act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);


        //assert
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void validateCredentialsInalidPassword() {
        //arrange
        String expectedUsername = "correctusername";
        String expectedPassword = "pass1234";
        User expectedOutput = null;
        User userFromDb = new User("correctusername", "pass123", "firstname", "lastname");
        Mockito.when(userDAO.getUserByUsername(expectedUsername)).thenReturn(userFromDb);

        //act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);

        //assert
        assertEquals(expectedOutput, actualOutput);
    }

    /*@Test
    void validateCredentialsValidCredentials() {
        //arrange
        String expectedUsername = "correctusername";
        String expectedPassword = "correctpassword";
        User expectedOutput = new User(expectedUsername, expectedPassword, "user", "one");
        Mockito.when(userDAO.getUserByUsername(expectedUsername)).thenReturn(expectedOutput);

        //act
        User actualOutput = userService.validateCredentials(expectedUsername, expectedPassword);

        //assert
        assertEquals(expectedOutput, actualOutput);

    }

    @Test
    void createUser(){
        //arrange

        User userToPass = new User("username", "password", "firstname", "lastname");

        //act
        userService.createUser(userToPass);

        //assert
        Mockito.verify(userDAO, Mockito.times(1)).createUser(userToPass);
    }*/


}