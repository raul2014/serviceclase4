package com.eduit.service.action;

import com.eduit.service.exceptions.NotFoundExecption;
import com.eduit.service.model.Car;
import com.eduit.service.repository.CarRepository;
import com.eduit.service.resource.response.CarResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CarAction {


    private CarRepository carRepository;

    @Autowired
    public CarAction(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    public CarResponse getCarById(Long id){
        Optional<Car> carOpc = carRepository.findById(id);
        Car car = carOpc.orElseThrow(()->new NotFoundExecption("car id " + id + " not found "));
        return new CarResponse(car.getId(),car.getBrand(),car.getModel(),car.getPrice());


    }


}
