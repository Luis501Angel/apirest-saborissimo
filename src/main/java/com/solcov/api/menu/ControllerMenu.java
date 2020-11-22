package com.solcov.api.menu;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@EnableAutoConfiguration
public class ControllerMenu {

    @Autowired
    private IRepositoryMenu repositoryMenu;

    @RequestMapping(value = "/menu", method = RequestMethod.POST)
    @ApiOperation(value = "Create a new daily menu")
    public boolean createMenu(@RequestBody Menu menu){
        try{
            repositoryMenu.save(menu);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/menu", method = RequestMethod.GET)
    @ApiOperation(value = "Get the daily menu")
    public List<Menu> getAllMenus(){
        return repositoryMenu.findAll();
    }

    @RequestMapping(value = "/menu/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Delete the daily menu")
    public boolean deleteMenu(@PathVariable Long id){
        try {
            repositoryMenu.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
