package com.egen.order.model;

import com.egen.order.entity.ItemDetail;
import com.egen.order.entity.PaymentInfo;
import com.egen.order.entity.ShippingAddress;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

public class OrderDetail {

    private Long id;
    private Integer customerId;
    private BigDecimal shippingCharges;
    private BigDecimal tax;
    private BigDecimal subtotalAmount;
    private BigDecimal totalAmount;
    private String status;
    private Timestamp creationDateAndTime;
    private Timestamp updateDateAndTime;
    private String user;
    private Set<PaymentInfo> paymentInfoDetails;
    private Set<ItemDetail> itemDetails;

    private ShippingAddress shippingAddress;

    public Set<PaymentInfo> getPaymentInfoDetails() {
        return paymentInfoDetails;
    }

    public void setPaymentInfoDetails(Set<PaymentInfo> paymentInfoDetails) {
        this.paymentInfoDetails = paymentInfoDetails;
    }

    public ShippingAddress getShippingAddress() {
        return shippingAddress;
    }

    public void setShippingAddress(ShippingAddress shippingAddress) {
        this.shippingAddress = shippingAddress;
    }

    public Set<ItemDetail> getItemDetails() {
        return itemDetails;
    }

    public void setItemDetails(Set<ItemDetail> itemDetails) {
        this.itemDetails = itemDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public BigDecimal getShippingCharges() {
        return shippingCharges;
    }

    public void setShippingCharges(BigDecimal shippingCharges) {
        this.shippingCharges = shippingCharges;
    }

    public BigDecimal getTax() {
        return tax;
    }

    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }

    public BigDecimal getSubtotalAmount() {
        return subtotalAmount;
    }

    public void setSubtotalAmount(BigDecimal subtotalAmount) {
        this.subtotalAmount = subtotalAmount;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getCreationDateAndTime() {
        return creationDateAndTime;
    }

    public void setCreationDateAndTime(Timestamp creationDateAndTime) {
        this.creationDateAndTime = creationDateAndTime;
    }

    public Timestamp getUpdateDateAndTime() {
        return updateDateAndTime;
    }

    public void setUpdateDateAndTime(Timestamp updateDateAndTime) {
        this.updateDateAndTime = updateDateAndTime;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
