package com.datangedu.cn.model.cart;

public class Cart extends CartKey {
    private Integer cartPrice;

    private Integer cartNumber;

    private Integer cartAprice;

    public Integer getCartPrice() {
        return cartPrice;
    }

    public void setCartPrice(Integer cartPrice) {
        this.cartPrice = cartPrice;
    }

    public Integer getCartNumber() {
        return cartNumber;
    }

    public void setCartNumber(Integer cartNumber) {
        this.cartNumber = cartNumber;
    }

    public Integer getCartAprice() {
        return cartAprice;
    }

    public void setCartAprice(Integer cartAprice) {
        this.cartAprice = cartAprice;
    }
}