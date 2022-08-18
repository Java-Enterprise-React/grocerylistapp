package com.revature.dao;

import java.util.List;

import com.revature.models.User;

/* 
 * DAO stands for Data Access Object
 *  - this should be the only location where we hit the database
 * 
 * 
 * What is an interface?
 *      - Its a contract between the interface itself, and the classes that implement it
 */
public interface UserDao {

    //variables in an interface are public static final

    /* public User[] getAllUsers(){
        return Store.users;
    } */

    // methods in an interface are implicitly public abstract
    List<User> getAllUsers();

    User getUserByUsername(String username);

    void createUser(User user);


}
