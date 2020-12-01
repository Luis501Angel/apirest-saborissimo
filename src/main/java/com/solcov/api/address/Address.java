package com.solcov.api.address;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Address implements Serializable{

    @Id
    private Long id;

    @ApiModelProperty(value = "Primera calle para la direccion")
    private String street1;

    @ApiModelProperty(value = "Segunda calle para la direccion")
    private String street2;

    @ApiModelProperty(value = "Colonia para la direccion")
    private String colony;

    @ApiModelProperty(value = "Referencias para la direccion")
    private String address_references;

    public Address() {
    }

    public Address(Long id) {
        this.id = id;
    }

    public Address(Long id, String street1, String street2, String colony, String address_references) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.colony = colony;
        this.address_references = address_references;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getColony() {
        return colony;
    }

    public void setColony(String colony) {
        this.colony = colony;
    }

    public String getReferences() {
        return address_references;
    }

    public void setReferences(String address_references) {
        this.address_references = address_references;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", street1='" + street1 + '\'' +
                ", street2='" + street2 + '\'' +
                ", colony='" + colony + '\'' +
                ", address_references='" + address_references + '\'' +
                '}';
    }
}
