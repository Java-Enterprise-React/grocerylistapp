package com.revature;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.revature.controllers.GroceryItemController;
import com.revature.controllers.SessionController;
import com.revature.controllers.UserController;

import io.javalin.Javalin;

/**
 * Grocery List
 *  register a new user
 *  login as a new user
 *  When im logged in,
 *      create new grocery list item
 *          be able to define 
 *              qty of that item
 *              value to see if item is in cart
 *      delete a grocery list item
 *      update if the item is in cart
 * 
 * I want to be able to persist the data (eventually)
 * 
 * 
 * What does a user need?
 *      - username (unique)
 *      - password
 *      - firstname
 *      - lastname
 * 
 *
 */
public class App 
{
    static Logger logger = LogManager.getLogger(App.class);
    public static void main( String[] args )
    {

        UserController userController = new UserController();
        GroceryItemController groceryItemController = new GroceryItemController();
        SessionController sessionController = new SessionController();

        /* MainMenu mainMenu = new MainMenu();
        mainMenu.view(); */

        Javalin app = Javalin.create().start(9000);


        //register user
        app.post("/api/user", userController::register);


        //session endpoints
        app.get("/api/session", sessionController::checkSession);
        app.post("/api/session", sessionController::login);
        app.delete("/api/session", sessionController::logout);

        //grocery item endpoints
        app.get("/api/item", groceryItemController::getAllItemsGivenUserId);
        app.post("/api/item", groceryItemController::createItem);
        app.patch("/api/item/{itemId}", groceryItemController::markItemComplete);
        app.delete("/api/item/{itemId}", groceryItemController::deleteItem);


        /* 
         * Log4j allows to log exceptions into a file
         * 
         * 
         * log4j has logging priorities:
         * All > debug > info > warn > error > fatal
         * 
         */



    }
}
