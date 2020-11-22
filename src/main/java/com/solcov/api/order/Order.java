package com.solcov.api.order;

import com.solcov.api.address.Address;
import com.solcov.api.client.Client;
import com.solcov.api.menuorder.MenuOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "order_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_generator", sequenceName = "s_order_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    @NotEmpty()
    @ApiModelProperty(value = "State of the order")
    private boolean state;

    @NotEmpty()
    @ApiModelProperty(value = "Menu of the order")
    private MenuOrder order;

    @Size(max = 8)
    @NotEmpty()
    @ApiModelProperty(value = "Type of the order")
    private String orderType;

    @ApiModelProperty(value = "Extras of the order")
    private String extras;

    @ApiModelProperty(value = "Comments of the order")
    private String comments;

    @NotEmpty()
    @ApiModelProperty(value = "Address of the order")
    private Address address;

    @NotEmpty()
    @ApiModelProperty(value = "Client of the order")
    private Client client;

    public Order() {
    }

    public Order(Long id, boolean state, MenuOrder order, String orderType, String extras, String comments, Address address, Client client) {
        this.id = id;
        this.state = state;
        this.order = order;
        this.orderType = orderType;
        this.extras = extras;
        this.comments = comments;
        this.address = address;
        this.client = client;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isState() {
        return state;
    }

    public void setState(boolean state) {
        this.state = state;
    }

    public MenuOrder getOrder() {
        return order;
    }

    public void setOrder(MenuOrder order) {
        this.order = order;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getExtras() {
        return extras;
    }

    public void setExtras(String extras) {
        this.extras = extras;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
}
