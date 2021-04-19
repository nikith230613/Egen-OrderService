package com.egen.order.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "customer_id")
    private Integer customerId;
    @Column(name = "shipping_charges")
    private BigDecimal shippingCharges;
    @Column(name = "tax")
    private BigDecimal tax;
    @Column(name = "subtotal_amount")
    private BigDecimal subtotalAmount;
    @Column(name = "total_amount")
    private BigDecimal totalAmount;
    @Column(name = "status")
    private String status;
    @Column(name = "creation_date")
    private Timestamp creationDateAndTime;
    @Column(name = "modified_date")
    private Timestamp updateDateAndTime;
    @Column(name = "user_id")
    private String user;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<PaymentInfo> paymentInfoDetails;
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Set<ItemDetail> itemDetails;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sa_id", referencedColumnName = "id")
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
