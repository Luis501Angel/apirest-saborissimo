package com.solcov.api.menuorder;

import com.solcov.api.meal.Meal;

public class MenuOrder {

    private Long id;
    private Meal entrance;
    private Meal middle;
    private Meal stew;
    private Meal dessert;
    private Meal drink;

    public MenuOrder() {
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
