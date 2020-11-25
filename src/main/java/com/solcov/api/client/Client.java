package com.solcov.api.client;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class Client implements Serializable{

    @Id
    private Long id;

    @ApiModelProperty(value = "Nombre del cliente")
    private String name;

    @ApiModelProperty(value = "Numero de telefono del cliente")
    private Integer phone;

    public Client() {
    }

    public Client(Long id) {
        this.id = id;
    }

    public Client(Long id, String name, Integer phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPhone() {
        return phone;
    }

    public void setPhone(Integer phone) {
        this.phone = phone;
    }
}
