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
//    @Column(unique=true, name = "CUSTOMERID")
    private long CUSTOMER_ID;

    @NotNull
//    @Column(unique=true, name = "ADDRESSESID")
    private long ADDRESSES_ID;

    @NotNull
    private String ITEM_ID;

    @NotNull
//    @Enumerated(EnumType.STRING)
    private String STATUS;

    @NotNull
    private long AMOUNT;

    @ManyToOne
    @JoinColumn(name ="CUSTOMER_ID", insertable = false, updatable = false)
    public CustomersEntity getCustomers;

    public OrdersEntity(){}
    public OrdersEntity(long ID){
        this.ID = ID;
    }

    public OrdersEntity(long CUSTOMER_ID, long ADDRESSES_ID, String ITEM_ID, String STATUS, long AMOUNT) {
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

    public CustomersEntity getGetCustomers() {
        return getCustomers;
    }

    public void setGetCustomers(CustomersEntity getCustomers) {
        this.getCustomers = getCustomers;
    }

    public String getITEM_ID() {
        return ITEM_ID;
    }

    public void setITEM_ID(String ITEM_ID) {
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