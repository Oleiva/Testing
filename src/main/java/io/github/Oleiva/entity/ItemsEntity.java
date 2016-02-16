package io.github.Oleiva.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;


@Entity
@Table(name = "ListOfItems")
public class ItemsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private String SKU;

    @NotNull
    private String NAME;

    @NotNull
    private long PRICE;

    private long AMOUNT;

    public ItemsEntity(){}
    public ItemsEntity(long ID){
        this.ID=ID;
    }

    public ItemsEntity(String SKU, String NAME, long PRICE, long AMOUNT) {
        this.SKU = SKU;
        this.NAME = NAME;
        this.PRICE = PRICE;
        this.AMOUNT = AMOUNT;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public long getPRICE() {
        return PRICE;
    }

    public void setPRICE(long PRICE) {
        this.PRICE = PRICE;
    }

    public long getAMOUNT() {
        return AMOUNT;
    }

    public void setAMOUNT(long AMOUNT) {
        this.AMOUNT = AMOUNT;
    }


}
