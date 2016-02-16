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
@Table(name = "ListOfOrders")
public class ListOfOrdersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private long CUSTOMERID;

    @NotNull
    private long ADDRESSESID;

    @NotNull
    private String SKU;

    @NotNull
    private long AMOUNT;

    public ListOfOrdersEntity(){}
    public ListOfOrdersEntity(long ID){
        this.ID = ID;
    }

    public ListOfOrdersEntity(long CUSTOMERID, long ADDRESSESID, String SKU, long AMOUNT) {
        this.CUSTOMERID = CUSTOMERID;
        this.ADDRESSESID = ADDRESSESID;
        this.SKU = SKU;
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
}