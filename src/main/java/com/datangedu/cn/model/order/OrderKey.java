package com.datangedu.cn.model.order;

public class OrderKey {
    private Integer ordeId;

    private String ordeCustomerid;

    public Integer getOrdeId() {
        return ordeId;
    }

    public void setOrdeId(Integer ordeId) {
        this.ordeId = ordeId;
    }

    public String getOrdeCustomerid() {
        return ordeCustomerid;
    }

    public void setOrdeCustomerid(String ordeCustomerid) {
        this.ordeCustomerid = ordeCustomerid == null ? null : ordeCustomerid.trim();
    }
}