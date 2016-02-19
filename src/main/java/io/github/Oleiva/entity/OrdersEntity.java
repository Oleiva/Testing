package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;


@Entity
@Table(name = "ORDERS")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private long orderId;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }


    @NotNull
    private long CUSTOMER_ID;

    @NotNull
    private long ADDRESSES_ID;

    @NotNull
    private long ITEM_ID;

    @NotNull
    private String STATUS;

    @NotNull
    private long AMOUNT;

//    @ManyToOne
//    @JoinColumn(name ="CUSTOMER_ID", insertable = false, updatable = false)
//    public CustomersEntity getCustomers;

    public OrdersEntity(){}
    public OrdersEntity(long ID){
        this.ID = ID;
    }

    public OrdersEntity(long orderId, long CUSTOMER_ID, long ADDRESSES_ID, long ITEM_ID, String STATUS, long AMOUNT) {
        this.orderId = orderId;
        this.CUSTOMER_ID = CUSTOMER_ID;
        this.ADDRESSES_ID = ADDRESSES_ID;
        this.ITEM_ID = ITEM_ID;
        this.STATUS = STATUS;
        this.AMOUNT = AMOUNT;
    }


    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getCUSTOMER_ID() {
        return CUSTOMER_ID;
    }

    public void setCUSTOMER_ID(long CUSTOMER_ID) {
        this.CUSTOMER_ID = CUSTOMER_ID;
    }

    public long getADDRESSES_ID() {
        return ADDRESSES_ID;
    }

    public void setADDRESSES_ID(long ADDRESSES_ID) {
        this.ADDRESSES_ID = ADDRESSES_ID;
    }

    public long getITEM_ID() {
        return ITEM_ID;
    }

    public void setITEM_ID(long ITEM_ID) {
        this.ITEM_ID = ITEM_ID;
    }

    public long getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(long AMOUNT) {
        this.AMOUNT = AMOUNT;
    }

    public String getSTATUS() {
        return STATUS;
    }

    public void setSTATUS(String STATUS) {
        this.STATUS = STATUS;
    }

}