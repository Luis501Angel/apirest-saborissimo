package com.solcov.api.order;

import com.solcov.api.meal.Meal;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class ControllerOrder {

    @Autowired
    private IRepositoryOrder repositoryOrder;

    @RequestMapping(value = "/order", method = RequestMethod.POST)
    @ApiOperation(value = "Crea una nueva orden de pedido")
    public boolean createOrder(@RequestBody Order order){
        try {
            System.out.println(order.getId());
            repositoryOrder.save(order);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene una orden por ID")
    public Order getOrder(@PathVariable Long id){
        Optional<Order> order = repositoryOrder.findById(id);
        if(order.isPresent()){
            return order.get();
        } else {
            return order.get();
        }
    }

    @RequestMapping(value = "/order", method = RequestMethod.GET)
    @ApiOperation(value = "Obtiene todas las ordenes")
    public List<Order> getAllOrders(){
        return repositoryOrder.findAll();
    }

    @RequestMapping(value = "/order/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un orden de pedido")
    public boolean updateMeal(@RequestBody Order order, @PathVariable Long id) {
        try {
            order.setId(id);
            repositoryOrder.save(order);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/order", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina todas las ordenes")
    public boolean deleteAllOrders(){
        try{
            repositoryOrder.deleteAll();
            return true;
        } catch (Exception e){
            return false;
        }
    }

}
