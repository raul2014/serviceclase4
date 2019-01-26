package com.eduit.service.repository;


import com.eduit.service.model.Car;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;
    private Optional<Car> carOpc;

    @Before
    public void init(){
        Car car = new Car("fiat","palio",80000D);
        carRepository.save(car);
    }

    @After
    public void after(){
        carRepository.deleteAll();
    }

    @Test
    public void mustFindCarWithIdOne(){
        givenCarRepository();
        whenFindCarWithIdOne();
        thenShouldFindCarWithIdOne();
    }

    private void thenShouldFindCarWithIdOne() {
        Assert.assertEquals(true, carOpc.isPresent());
    }

    private void whenFindCarWithIdOne() {
        carOpc = carRepository.findById(1L);
    }


    public CarRepository givenCarRepository() {
        return carRepository;
    }
}
