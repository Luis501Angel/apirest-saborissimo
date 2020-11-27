package com.solcov.api.menu;

import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "meal_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "meal_generator", sequenceName = "s_meal_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "ID del menu diario")
    private Long id;

    @NotEmpty
    @ApiModelProperty(value = "Entradas del menu diario")
    private Meal[] entrances;

    @NotEmpty
    @ApiModelProperty(value = "Medios del menu diario")
    private Meal[] middles;

    @NotEmpty
    @ApiModelProperty(value = "Guisados del menu diario")
    private Meal[] stews;

    @NotEmpty
    @ApiModelProperty(value = "Postres del menu diario")
    private Meal[] desserts;

    @NotEmpty
    @ApiModelProperty(value = "Bebidas del menu diario")
    private Meal[] drinks;


    public Menu() {
    }

    public Menu(Long id, Meal[] entrances, Meal[] middles, Meal[] stews, Meal[] desserts, Meal[] drinks) {
        this.id = id;
        this.entrances = entrances;
        this.middles = middles;
        this.stews = stews;
        this.desserts = desserts;
        this.drinks = drinks;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Meal[] getEntrances() {
        return entrances;
    }

    public void setEntrances(Meal[] entrances) {
        this.entrances = entrances;
    }

    public Meal[] getMiddles() {
        return middles;
    }

    public void setMiddles(Meal[] middles) {
        this.middles = middles;
    }

    public Meal[] getStews() {
        return stews;
    }

    public void setStews(Meal[] stews) {
        this.stews = stews;
    }

    public Meal[] getDesserts() {
        return desserts;
    }

    public void setDesserts(Meal[] desserts) {
        this.desserts = desserts;
    }

    public Meal[] getDrinks() {
        return drinks;
    }

    public void setDrinks(Meal[] drinks) {
        this.drinks = drinks;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "id=" + id +
                ", entrances=" + Arrays.toString(entrances) +
                ", middles=" + Arrays.toString(middles) +
                ", stews=" + Arrays.toString(stews) +
                ", desserts=" + Arrays.toString(desserts) +
                ", drinks=" + Arrays.toString(drinks) +
                '}';
    }
}
