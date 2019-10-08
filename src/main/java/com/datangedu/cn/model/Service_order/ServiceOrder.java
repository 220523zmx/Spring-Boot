package com.datangedu.cn.model.Service_order;

import java.util.Date;

public class ServiceOrder {
    private String id;

    private String serviceId;

    private String orderId;

    private String productId;

    private String serivceId;

    private String serviceName;

    private String serviceInfo;

    private Integer unitPrice;

    private Integer buyNum;

    private Integer totalPrice;

    private Integer status;

    private Date createTime;

    private String servicePequest;

    private String proviceId;

    private String unit;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId == null ? null : productId.trim();
    }

    public String getSerivceId() {
        return serivceId;
    }

    public void setSerivceId(String serivceId) {
        this.serivceId = serivceId == null ? null : serivceId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getServiceInfo() {
        return serviceInfo;
    }

    public void setServiceInfo(String serviceInfo) {
        this.serviceInfo = serviceInfo == null ? null : serviceInfo.trim();
    }

    public Integer getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Integer unitPrice) {
        this.unitPrice = unitPrice;
    }

    public Integer getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(Integer buyNum) {
        this.buyNum = buyNum;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getServicePequest() {
        return servicePequest;
    }

    public void setServicePequest(String servicePequest) {
        this.servicePequest = servicePequest == null ? null : servicePequest.trim();
    }

    public String getProviceId() {
        return proviceId;
    }

    public void setProviceId(String proviceId) {
        this.proviceId = proviceId == null ? null : proviceId.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }
}