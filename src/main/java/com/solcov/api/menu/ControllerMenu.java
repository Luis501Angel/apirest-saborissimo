package com.solcov.api.menu;

import com.solcov.api.meal.ControllerMeal;
import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@EnableAutoConfiguration
public class ControllerMenu {

    @Autowired
    private IRepositoryMenu repositoryMenu;

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo menu diario")
    public boolean createMenu(@RequestBody Menu menu){
        try{
            repositoryMenu.save(menu);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    /*@RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene el menu diario")
    public MenuDaily getMenuDaily(){
        List<Long> idEntrances  = repositoryMenu.findMenu_entrances();
        List<Meal> entrances = new ArrayList<>();
        ControllerMeal controllerMeal = new ControllerMeal();
        for(int i = 0; i < idEntrances.size(); i ++){
            entrances.set(i, controllerMeal.getMealTest(Long.valueOf(1)));
        }
        MenuDaily menuDaily = new MenuDaily(entrances, entrances, entrances, entrances, entrances);
        return menuDaily;
    }*/

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene el menu diario")
    public List<Menu> getMenuDaily(){
        return  repositoryMenu.findAll();
    }

    @RequestMapping(value = "/menu", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina el menu diario")
    public boolean deleteMenu(){
        try {
            repositoryMenu.deleteAll();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
