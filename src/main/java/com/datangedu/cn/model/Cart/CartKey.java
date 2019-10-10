package com.datangedu.cn.model.cart;

public class CartKey {
    private String cartCustomerid;

    private String cartProviderid;

    private String cartProductid;

    public String getCartCustomerid() {
        return cartCustomerid;
    }

    public void setCartCustomerid(String cartCustomerid) {
        this.cartCustomerid = cartCustomerid == null ? null : cartCustomerid.trim();
    }

    public String getCartProviderid() {
        return cartProviderid;
    }

    public void setCartProviderid(String cartProviderid) {
        this.cartProviderid = cartProviderid == null ? null : cartProviderid.trim();
    }

    public String getCartProductid() {
        return cartProductid;
    }

    public void setCartProductid(String cartProductid) {
        this.cartProductid = cartProductid == null ? null : cartProductid.trim();
    }
}