package com.solcov.api.meal;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tb_meal")
public class Meal implements Serializable {

    @Id
    @GeneratedValue(generator = "meal_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "meal_generator", sequenceName = "s_meal_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "ID del platillo")
    private Long id;

    @Size(max = 255)
    @NotEmpty()
    @ApiModelProperty(value = "Nombre del platillo")
    private String name;

    @NotEmpty()
    @ApiModelProperty(value = "Descripcion del platillo")
    private String description;

    @NotEmpty()
    @ApiModelProperty(value = "Enlace a la foto del platillo")
    private String picture;

    @NotEmpty()
    @ApiModelProperty(value = "Tipo de platillo")
    private String type;

    public Meal() {
    }

    public Meal(Long id) {
        this.id = id;
    }

    public Meal(Long id, String name, String description, String picture, String type) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.picture = picture;
        this.type = type;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", picture='" + picture + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
