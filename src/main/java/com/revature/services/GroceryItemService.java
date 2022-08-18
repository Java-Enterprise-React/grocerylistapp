package com.revature.services;

import java.util.List;

import com.revature.dao.GroceryItemDao;
import com.revature.dao.GroceryItemDaoImpl;
import com.revature.models.GroceryItem;

public class GroceryItemService {

    GroceryItemDao groceryItemDao = new GroceryItemDaoImpl();

    public void createGroceryItem(GroceryItem groceryItem){
        this.groceryItemDao.createGroceryItem(groceryItem);
    }

    public List<GroceryItem> getAllGroceryItemsGivenUserId(Integer userId){
        return this.groceryItemDao.getAllItemsGivenUserId(userId);
    }

    public void deleteAGroceryItemGivenGroceryId(Integer groceryItemId){
        this.groceryItemDao.deleteGroceryItem(groceryItemId);
    }

    public void markInCartGivenGroceryId(Integer groceryItemId){
        this.groceryItemDao.markGroceryItemInCart(groceryItemId);
    }
}
