package com.revature.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.revature.dao.UserDao;
import com.revature.models.User;

public class UserServiceTest {

    UserDao userDao = Mockito.mock(UserDao.class);
    UserService userService = new UserService(userDao);


    @Test
    void testValidateCredentialsValidCredentials() {
        //arrange
        User objToPass = new User("kev123", "pass123");
        Mockito.when(userDao.getUserByUsername(objToPass.getUsername())).thenReturn(objToPass);

        //act
        Boolean actualResult = userService.validateCredentials(objToPass);

        //assert
        Assertions.assertTrue(actualResult);
    }

    @Test
    void testValidateCredentialsInvalidUsername() {
        //arrange
        User objToPass = new User("kev123", "pass123");
        Mockito.when(userDao.getUserByUsername(objToPass.getUsername())).thenReturn(null);

        //act
        Boolean actualResult = userService.validateCredentials(objToPass);

        //assert
        Assertions.assertFalse(actualResult);
    }

    @Test
    void testValidateCredentialsInvalidPassword() {
        //arrange
        User objToPass = new User("kev123", "pass123");
        User objReturnedFromDb = new User("kev123", "pass1234");
        Mockito.when(userDao.getUserByUsername(objToPass.getUsername())).thenReturn(objReturnedFromDb);

        //act
        Boolean actualResult = userService.validateCredentials(objToPass);

        //assert
        Assertions.assertFalse(actualResult);
    }


}
