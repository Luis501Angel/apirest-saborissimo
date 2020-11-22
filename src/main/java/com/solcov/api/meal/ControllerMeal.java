package com.solcov.api.meal;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class ControllerMeal {

    @Autowired
    private IRepositoryMeal repositoryMeal;

    @RequestMapping(value = "/meal", method = RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo platillo")
    public boolean createMeal(@RequestBody Meal meal){
        try {
            repositoryMeal.save(meal);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/meal/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca un platillo por ID")
    public Meal getMeal(@PathVariable Long id){
        Optional<Meal> meal = repositoryMeal.findById(id);
        if(meal.isPresent()){
            return meal.get();
        } else {
            return meal.get();
        }
    }

    @RequestMapping(value = "/meal", method = RequestMethod.GET)
    @ApiOperation(value = "Busca todos los platillos")
    public List<Meal> getAllMeals() {
        return repositoryMeal.findAll();
    }

    @RequestMapping(value = "/meal/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un platillo")
    public boolean updateMeal(@RequestBody Meal meal, @PathVariable Long id) {
        try {
            meal.setId(id);
            repositoryMeal.save(meal);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/meal/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina un platillo por ID")
    public boolean deleteMeal(@PathVariable Long id) {
        try {
            repositoryMeal.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }
}