package io.github.Oleiva.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@Entity
@Table(name = "CUSTOMERS")
public class CustomersEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ID;

    @NotNull
    private String USERNAME;

    @NotNull
    @Column(unique=true, name = "EMAIL")
    private String EMAIL;

    private long AVAILABLECREDIT;

    @OneToMany(mappedBy = "ID" )
    private List<ShippingAddressesEntity> shippingAddressesEntities;

    public List<ShippingAddressesEntity> getShippingAddressesEntities() {
        return shippingAddressesEntities;
    }

    public void setShippingAddressesEntities(List<ShippingAddressesEntity> shippingAddressesEntities) {
        this.shippingAddressesEntities = shippingAddressesEntities;
    }

    public CustomersEntity(){}

    public CustomersEntity(long ID) {
        this.ID = ID;
    }

    public CustomersEntity(String USERNAME, String EMAIL, long AVAILABLECREDIT) {
        this.USERNAME = USERNAME;
        this.EMAIL = EMAIL;
        this.AVAILABLECREDIT = AVAILABLECREDIT;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }

    public long getAVAILABLECREDIT() {
        return AVAILABLECREDIT;
    }

    public void setAVAILABLECREDIT(long AVAILABLECREDIT) {
        this.AVAILABLECREDIT = AVAILABLECREDIT;
    }
}
