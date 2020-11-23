package com.solcov.api.menu;

import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.List;

@Entity
@Table(name = "tb_menu")
public class Menu {

    @Id
    @GeneratedValue(generator = "meal_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "meal_generator", sequenceName = "s_meal_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    @NotEmpty
    @ApiModelProperty(value = "Entradas del menu diario")
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey(name = "entrances_menu_fk"), name = "entrances")
    private List<Meal> entrances;

    @NotEmpty
    @ApiModelProperty(value = "Medios del menu diario")
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey(name = "middles_menu_fk"), name = "middles")
    private List<Meal> middles;

    @NotEmpty
    @ApiModelProperty(value = "Guisados del menu diario")
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey(name = "stews_menu_fk"), name = "stews")
    private List<Meal> stews;

    @NotEmpty
    @ApiModelProperty(value = "Postres del menu diario")
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey(name = "desserts_menu_fk"), name = "desserts")
    private List<Meal> desserts;

    @NotEmpty
    @ApiModelProperty(value = "Bebidas del menu diario")
    @OneToMany
    @JoinColumn(foreignKey = @ForeignKey(name = "drinks_menu_fk"), name = "drinks")
    private List<Meal> drinks;


    public Menu() {
    }

    public Menu(Long id, List<Meal> entrances, List<Meal> middles, List<Meal> stews, List<Meal> desserts, List<Meal> drinks) {
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
