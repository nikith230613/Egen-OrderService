package com.egen.order.common;

public enum OrderStatus {
    CANCELLED("CANCELLED", "Order Cancelled "),
    CREATED("CREATED", "Order created")
    ;
    private String status;
    private String desc;

    OrderStatus(String status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
