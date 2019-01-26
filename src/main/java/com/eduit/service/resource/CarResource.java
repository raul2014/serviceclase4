package com.eduit.service.resource;

import com.eduit.service.action.CarAction;
import com.eduit.service.resource.response.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarResource {


    private CarAction carAction;

    @Autowired
    public CarResource(CarAction carAction) {
        this.carAction = carAction;
    }

    @GetMapping(path = "car/{id}",produces = "application/json")
    public CarResponse getAutoById(@PathVariable(name = "id") Long id){

        return carAction.getCarById(id);
    }


}
