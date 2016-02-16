package io.github.Oleiva.entity;

import javax.validation.constraints.NotNull;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "ListOfShippingAddresses")
public class ListOfShippingAddressesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private long CUSTOMERID;

    @NotNull
    private int POSTALCODE;

    @NotNull
    private String STREET;

    @NotNull
    private int HOUSE;

    private int FLAT;


    public ListOfShippingAddressesEntity(){}

    public ListOfShippingAddressesEntity(long ID){
        this.ID = ID;
    }

    public ListOfShippingAddressesEntity(long CUSTOMERID, int POSTALCODE, String STREET, int HOUSE, int FLAT) {
        this.CUSTOMERID = CUSTOMERID;
        this.POSTALCODE = POSTALCODE;
        this.STREET = STREET;
        this.HOUSE = HOUSE;
        this.FLAT = FLAT;
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

    public int getPOSTALCODE() {
        return POSTALCODE;
    }

    public void setPOSTALCODE(int POSTALCODE) {
        this.POSTALCODE = POSTALCODE;
    }

    public String getSTREET() {
        return STREET;
    }

    public void setSTREET(String STREET) {
        this.STREET = STREET;
    }

    public int getHOUSE() {
        return HOUSE;
    }

    public void setHOUSE(int HOUSE) {
        this.HOUSE = HOUSE;
    }

    public int getFLAT() {
        return FLAT;
    }

    public void setFLAT(int FLAT) {
        this.FLAT = FLAT;
    }
}
