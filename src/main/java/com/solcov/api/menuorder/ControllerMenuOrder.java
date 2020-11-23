package com.solcov.api.menuorder;

import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class ControllerMenuOrder {

    @Autowired
    private IRepositoryMenuOrder repositoryMenuOrder;

    @RequestMapping(value = "/menu-order", method = RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo menu para la orden")
    public boolean createMenuOrder(@RequestBody MenuOrder menuOrder){
        try {
            repositoryMenuOrder.save(menuOrder);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/menu-order/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca una orden de un menu por ID")
    public MenuOrder getMenuOrder(@PathVariable Long id){
        Optional<MenuOrder> menuOrder = repositoryMenuOrder.findById(id);
        if(menuOrder.isPresent()){
            return menuOrder.get();
        } else {
            return menuOrder.get();
        }
    }

    @RequestMapping(value = "/menu-order", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina todas las ordenes de los menus")
    public boolean deleteMenuOrder(@PathVariable Long id) {
        try {
            repositoryMenuOrder.deleteAll();
            return true;
        } catch(Exception e){
            return false;
        }
    }

}
