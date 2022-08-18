package com.revature.controllers;

import java.util.ArrayList;
import java.util.List;

import com.revature.models.GroceryItem;
import com.revature.models.JsonResponse;
import com.revature.models.User;
import com.revature.services.GroceryItemService;

import io.javalin.http.Context;

public class GroceryItemController {

    GroceryItemService groceryItemService = new GroceryItemService();

    public void getAllItemsGivenUserId(Context ctx){
        User user = ctx.sessionAttribute("user");

        List<GroceryItem> items = groceryItemService.getAllGroceryItemsGivenUserId(user.getId());

        ctx.json(new JsonResponse(true, "retrieving all items for " + user.getFirstname(), items));
    }

    public void createItem(Context ctx){
        GroceryItem groceryItem = ctx.bodyAsClass(GroceryItem.class);
        User userFromSession = ctx.sessionAttribute("user");
        groceryItem.setUserIdFk(userFromSession.getId());


        groceryItemService.createGroceryItem(groceryItem);

        ctx.json(new JsonResponse(true, "Item created", null));
    }

    public void deleteItem(Context ctx){
        Integer groceryItemId = Integer.parseInt(ctx.pathParam("itemId"));

        groceryItemService.deleteAGroceryItemGivenGroceryId(groceryItemId);

        ctx.json(new JsonResponse(true, "item deleted if exists", null));

    }

    public void markItemComplete(Context ctx){
        Integer groceryItemId = Integer.parseInt(ctx.pathParam("itemId"));

        groceryItemService.markInCartGivenGroceryId(groceryItemId);

        ctx.json(new JsonResponse(true, "item marked in cart if exists", null));
    }
}
