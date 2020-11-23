package com.solcov.api.menu;

import com.solcov.api.meal.Meal;

import java.util.List;

public class MenuDaily {

    private List<Meal> entrances;
    private List<Meal> middles;
    private List<Meal> stews;
    private List<Meal> desserts;
    private List<Meal> drinks;

    public MenuDaily() {
    }

    public MenuDaily(List<Meal> entrances, List<Meal> middles, List<Meal> stews, List<Meal> desserts, List<Meal> drinks) {
        this.entrances = entrances;
        this.middles = middles;
        this.stews = stews;
        this.desserts = desserts;
        this.drinks = drinks;
    }

    public List<Meal> getEntrances() {
        return entrances;
    }

    public void setEntrances(List<Meal> entrances) {
        this.entrances = entrances;
    }

    public List<Meal> getMiddles() {
        return middles;
    }

    public void setMiddles(List<Meal> middles) {
        this.middles = middles;
    }

    public List<Meal> getStews() {
        return stews;
    }

    public void setStews(List<Meal> stews) {
        this.stews = stews;
    }

    public List<Meal> getDesserts() {
        return desserts;
    }

    public void setDesserts(List<Meal> desserts) {
        this.desserts = desserts;
    }

    public List<Meal> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<Meal> drinks) {
        this.drinks = drinks;
    }
}
