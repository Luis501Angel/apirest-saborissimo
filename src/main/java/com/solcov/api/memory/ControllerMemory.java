package com.solcov.api.memory;

import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@RestController
@EnableAutoConfiguration
public class ControllerMemory {

    @Autowired
    private IRepositoryMemory repositoryMemory;

    @RequestMapping(value = "/memory", method = RequestMethod.POST)
    @ApiOperation(value = "Crea un nuevo recuerdo")
    public boolean createMemory(@RequestBody Memory memory){
        try{
            repositoryMemory.save(memory);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @RequestMapping(value = "/memory", method = RequestMethod.GET)
    @ApiOperation(value = "Busca todas las fotos de recuerdo")
    public List<Memory> getAllMemories(){
        List<Memory> lstMemories = repositoryMemory.findAll();
        return lstMemories;
    }

    @RequestMapping(value = "/memory/{id}", method = RequestMethod.GET)
    @ApiOperation(value = "Busca una foto de recuerdo por ID")
    public Memory getMemory(@PathVariable Long id){
        Optional<Memory> memory = repositoryMemory.findById(id);
        if(memory.isPresent()){
            return memory.get();
        } else {
            return memory.get();
        }
    }

    @RequestMapping(value = "/memory/{id}", method = RequestMethod.PUT)
    @ApiOperation(value = "Actualiza un recuerdo")
    public boolean updateMemory(@RequestBody Memory memory, @PathVariable Long id) {
        try {
            memory.setId(id);
            repositoryMemory.save(memory);
            return true;
        } catch(Exception e){
            return false;
        }
    }

    @RequestMapping(value = "/memory/{id}", method = RequestMethod.DELETE)
    @ApiOperation(value = "Elimina un recerdo por ID")
    public boolean deleteMemory(@PathVariable Long id) {
        try {
            repositoryMemory.deleteById(id);
            return true;
        } catch(Exception e){
            return false;
        }
    }


}
