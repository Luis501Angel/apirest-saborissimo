package com.solcov.api.menuorder;

import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;

@Entity
@Table(name = "tb_menu_order")
public class MenuOrder implements Serializable {

    @Id
    @GeneratedValue(generator = "order_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "order_generator", sequenceName = "s_order_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "Id del menu de la orden")
    private Long id;

    @ApiModelProperty(value = "Id del platillo para la entrada del menu")
    private Meal entrance;

    @ApiModelProperty(value = "Id del platillo para el medio del menu")
    private Meal middle;

    @ApiModelProperty(value = "Id del platillo para el guisado del menu")
    private Meal stew;

    @ApiModelProperty(value = "Id del platillo para el postre del menu")
    private Meal dessert;

    @ApiModelProperty(value = "Id del platillo para la bebida del menu")
    private Meal drink;

    public MenuOrder() {
    }

    public MenuOrder(Long id) {
        this.id = id;
    }

    public MenuOrder(Long id, Meal entrance, Meal middle, Meal stew, Meal dessert, Meal drink) {
        this.id = id;
        this.entrance = entrance;
        this.middle = middle;
        this.stew = stew;
        this.dessert = dessert;
        this.drink = drink;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meal getEntrance() {
        return entrance;
    }

    public void setEntrance(Meal entrance) {
        this.entrance = entrance;
    }

    public Meal getMiddle() {
        return middle;
    }

    public void setMiddle(Meal middle) {
        this.middle = middle;
    }

    public Meal getStew() {
        return stew;
    }

    public void setStew(Meal stew) {
        this.stew = stew;
    }

    public Meal getDessert() {
        return dessert;
    }

    public void setDessert(Meal dessert) {
        this.dessert = dessert;
    }

    public Meal getDrink() {
        return drink;
    }

    public void setDrink(Meal drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "MenuOrder{" +
                "id=" + id +
                ", entrance=" + entrance +
                ", middle=" + middle +
                ", stew=" + stew +
                ", dessert=" + dessert +
                ", drink=" + drink +
                '}';
    }
}
