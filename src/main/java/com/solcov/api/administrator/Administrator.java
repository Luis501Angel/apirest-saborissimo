package com.solcov.api.administrator;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "tb_administrator")
public class Administrator implements Serializable {

    @Id
    @GeneratedValue(generator = "administrator_generator", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "administrator_generator", sequenceName = "s_administrator_sequence", initialValue = 1, allocationSize = 1)
    private Long id;

    @Size(max = 255)
    @NotEmpty()
    @ApiModelProperty(value = "Nombre de usuario del administrador [rossi]")
    private String username;

    @NotEmpty()
    @ApiModelProperty(value = "Contraseña por defecto del administrador [sabo]")
    private String password;

    public Administrator() {
    }

    public Administrator(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
