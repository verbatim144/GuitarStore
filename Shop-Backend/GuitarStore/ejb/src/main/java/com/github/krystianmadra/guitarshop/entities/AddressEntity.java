package com.github.krystianmadra.guitarshop.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class AddressEntity extends AbstractBaseEntity{

    private String city;
    private String postalCode;
    private String phone;
    private String street;

    @OneToOne
    private UserEntity user;

    public AddressEntity() {
    }

    public AddressEntity(UserEntity user) {
        this.user = user;
    }

    public AddressEntity(Long id, String city, String postalCode, String phone, String street) {
        super(id);
        this.city = city;
        this.postalCode = postalCode;
        this.phone = phone;
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
