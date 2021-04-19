package com.egen.order.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "item_detail")
public class ItemDetail  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name")
    private String name;
    @Column(name = "qty")
    private Long qty;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "creation_date")
    private Timestamp creationDateAndTime;
    @Column(name = "modified_date")
    private Timestamp updateDateAndTime;
    @Column(name = "user_id")
    private String user;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private Order order;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getQty() {
        return qty;
    }

    public void setQty(Long qty) {
        this.qty = qty;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
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
