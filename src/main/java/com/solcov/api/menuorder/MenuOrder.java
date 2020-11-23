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

    @ManyToOne()
    @ApiModelProperty(value = "Id del platillo para la entrada del menu")
    @JoinColumn(foreignKey = @ForeignKey(name = "meal_entrance_to_menu_order_fk"), name = "entrance")
    private Meal entrance;

    @ManyToOne()
    @ApiModelProperty(value = "Id del platillo para el medio del menu")
    @JoinColumn(foreignKey = @ForeignKey(name = "meal_middle_to_menu_order_fk"), name = "middle")
    private Meal middle;

    @ManyToOne()
    @ApiModelProperty(value = "Id del platillo para el guisado del menu")
    @JoinColumn(foreignKey = @ForeignKey(name = "meal_stew_to_menu_order_fk"), name = "stew")
    private Meal stew;

    @ManyToOne()
    @ApiModelProperty(value = "Id del platillo para el postre del menu")
    @JoinColumn(foreignKey = @ForeignKey(name = "meal_dessert_to_menu_order_fk"), name = "dessert")
    private Meal dessert;

    @ManyToOne()
    @ApiModelProperty(value = "Id del platillo para la bebida del menu")
    @JoinColumn(foreignKey = @ForeignKey(name = "meal_drink_to_menu_order_fk"), name = "drink")
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
}
