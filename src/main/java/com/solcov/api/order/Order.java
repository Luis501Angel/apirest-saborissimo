package com.solcov.api.order;

import com.solcov.api.address.Address;
import com.solcov.api.client.Client;
import com.solcov.api.menuorder.MenuOrder;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import javax.validation.constraints.Size;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
@Table(name = "tb_order")
public class Order implements Serializable {

    @Id
    @GeneratedValue(generator = "order_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_generator", sequenceName = "s_order_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "ID de la orden")
    private Long id;

    @ApiModelProperty(value = "Estado actual de la orden [Entregado/No entregado]")
    private boolean state;

    @ApiModelProperty(value = "Menu seleccionado de la orden")
    @OneToOne
    @JoinColumn(foreignKey = @ForeignKey(name = "order_menu_fk"), name = "menu_order")
    private MenuOrder menuOrder;

    @Size(max = 8)
    @ApiModelProperty(value = "Tipo de pedido para la orden [PEDIDO/APARTADO]")
    @Column(name = "order_type")
    private String orderType;

    @ApiModelProperty(value = "Extras para el pedido")
    private String extras;

    @ApiModelProperty(value = "Comentarios del pedido")
    private String comments;

    @ApiModelProperty(value = "Direccion de envio en caso de escoger pedido a domicilio")
    private Address address;

    @ApiModelProperty(value = "Datos del cliente del pedido")
    private Client client;

    public Order() {
    }

    public Order(Long id, boolean state, MenuOrder menuOrder, String orderType, String extras, String comments, Address address, Client client) {
        this.id = id;
        this.state = state;
        this.menuOrder = menuOrder;
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

    public MenuOrder getMenuOrder() {
        return menuOrder;
    }

    public void setMenuOrder(MenuOrder menuOrder) {
        this.menuOrder = menuOrder;
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

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", state=" + state +
                ", menuOrder=" + menuOrder +
                ", orderType='" + orderType + '\'' +
                ", extras='" + extras + '\'' +
                ", comments='" + comments + '\'' +
                ", address=" + address +
                ", client=" + client +
                '}';
    }
}
