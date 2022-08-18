package com.revature.dao;

import java.util.List;

import com.revature.models.GroceryItem;

public interface GroceryItemDao {
    void createGroceryItem(GroceryItem groceryItem);
    List<GroceryItem> getAllItemsGivenUserId(Integer userId);
    void deleteGroceryItem(Integer groceryItemId);
    void markGroceryItemInCart(Integer groceryItemId);
}
