package com.solcov.api.menu;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    private Long id;

    @ApiModelProperty(value = "Entradas del menu diario")
    private String[] entrances;

    @ApiModelProperty(value = "Medios del menu diario")
    private String[] middles;

    @ApiModelProperty(value = "Guisados del menu diario")
    private String[] stews;

    @ApiModelProperty(value = "Postres del menu diario")
    private String[] desserts;

    @ApiModelProperty(value = "Bebidas del menu diario")
    private String[] drinks;


    public Menu() {
    }

    public Menu(Long id, String[] entrances, String[] middles, String[] stews, String[] desserts, String[] drinks) {
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

    public String[] getEntrances() {
        return entrances;
    }

    public void setEntrances(String[] entrances) {
        this.entrances = entrances;
    }

    public String[] getMiddles() {
        return middles;
    }

    public void setMiddles(String[] middles) {
        this.middles = middles;
    }

    public String[] getStews() {
        return stews;
    }

    public void setStews(String[] stews) {
        this.stews = stews;
    }

    public String[] getDesserts() {
        return desserts;
    }

    public void setDesserts(String[] desserts) {
        this.desserts = desserts;
    }

    public String[] getDrinks() {
        return drinks;
    }

    public void setDrinks(String[] drinks) {
        this.drinks = drinks;
    }
}
