package com.solcov.api.address;

public class Address {

    private Long id;
    private String street1;
    private String street2;
    private String colony;
    private String postalCode;
    private String references;

    public Address() {
    }

    public Address(Long id, String street1, String street2, String colony, String postalCode, String references) {
        this.id = id;
        this.street1 = street1;
        this.street2 = street2;
        this.colony = colony;
        this.postalCode = postalCode;
        this.references = references;
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

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getReferences() {
        return references;
    }

    public void setReferences(String references) {
        this.references = references;
    }
}
