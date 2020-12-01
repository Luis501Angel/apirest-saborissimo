package com.solcov.api.memory;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.SequenceGenerator;
import javax.persistence.GenerationType;
import java.io.Serializable;

@Entity
@Table(name = "tb_memory")
public class Memory implements Serializable {

    @Id
    @GeneratedValue(generator = "memory_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "memory_generator", sequenceName = "s_memory_sequence", initialValue = 1, allocationSize = 1)
    @ApiModelProperty(value = "ID del recuerdo")
    private Long id;

    @ApiModelProperty(value = "Titulo del recuerdo")
    private String title;

    @ApiModelProperty(value = "URL de la imagen del recuerdo")
    private String picture;

    @ApiModelProperty(value = "Fecha del recuerdo")
    private String date;

    public Memory() {
    }

    public Memory(Long id, String title, String picture, String date) {
        this.id = id;
        this.title = title;
        this.picture = picture;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Memory{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", picture='" + picture + '\'' +
                ", date='" + date + '\'' +
                '}';
    }
}
