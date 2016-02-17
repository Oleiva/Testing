package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "orders")
public class OrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
//    @Column(unique=true, name = "CUSTOMERID")
    private long CUSTOMERID;

    @NotNull
//    @Column(unique=true, name = "ADDRESSESID")
    private long ADDRESSESID;

    @NotNull
    private String SKU;

    @NotNull
    private String STATUS;

    @NotNull
    private long AMOUNT;

    public OrdersEntity(){}
    public OrdersEntity(long ID){
        this.ID = ID;
    }

    public OrdersEntity(long CUSTOMERID, long ADDRESSESID, String SKU, String STATUS, long AMOUNT) {
        this.CUSTOMERID = CUSTOMERID;
        this.ADDRESSESID = ADDRESSESID;
        this.SKU = SKU;
        this.STATUS = STATUS;
        this.AMOUNT = AMOUNT;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public long getCUSTOMERID() {
        return CUSTOMERID;
    }

    public void setCUSTOMERID(long CUSTOMERID) {
        this.CUSTOMERID = CUSTOMERID;
    }

    public long getADDRESSESID() {
        return ADDRESSESID;
    }

    public void setADDRESSESID(long ADDRESSESID) {
        this.ADDRESSESID = ADDRESSESID;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
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