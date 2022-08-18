package com.revature.models;


/* 
 * models should have:
 *  - the need constructors
 *  - getters and setters
 *  - toString
 * 
 */

public class GroceryItem {
    private Integer id;
    private String name;
    private Integer qty;
    private Boolean inCart;
    private Integer userIdFk;

    public GroceryItem(String name, Integer qty){
        this.name = name;
        this.qty = qty;
    }

    public GroceryItem(String name, Integer qty, Integer userIdFk){
        this.name = name;
        this.qty = qty;
        this.userIdFk = userIdFk;
    }

    public GroceryItem(String name){
        this.name = name;
    }


    public GroceryItem(Integer id, String name, Integer qty, Boolean inCart, Integer userIdFk) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.inCart = inCart;
        this.userIdFk = userIdFk;
    }

    public GroceryItem() {
    }



    public Integer getId() {
        return this.id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getQty() {
        return this.qty;
    }

    public void setQty(Integer qty) {
        this.qty = qty;
    }

    public Boolean isInCart() {
        return this.inCart;
    }

    public Boolean getInCart() {
        return this.inCart;
    }

    public void setInCart(Boolean inCart) {
        this.inCart = inCart;
    }

    public Integer getUserIdFk() {
        return this.userIdFk;
    }

    public void setUserIdFk(Integer userIdFk) {
        this.userIdFk = userIdFk;
    }


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", name='" + getName() + "'" +
            ", qty='" + getQty() + "'" +
            ", inCart='" + isInCart() + "'" +
            "}";
    }


}
