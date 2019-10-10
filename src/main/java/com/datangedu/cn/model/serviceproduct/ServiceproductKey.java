package com.datangedu.cn.model.serviceproduct;

public class ServiceproductKey {
    private String servProductid;

    private String servProviderid;

    public String getServProductid() {
        return servProductid;
    }

    public void setServProductid(String servProductid) {
        this.servProductid = servProductid == null ? null : servProductid.trim();
    }

    public String getServProviderid() {
        return servProviderid;
    }

    public void setServProviderid(String servProviderid) {
        this.servProviderid = servProviderid == null ? null : servProviderid.trim();
    }
}