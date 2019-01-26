package com.eduit.service.action;

import com.eduit.service.exceptions.NotFoundExecption;
import com.eduit.service.model.Car;
import com.eduit.service.repository.CarRepository;
import com.eduit.service.resource.response.CarResponse;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Optional;

public class CarActionTest {

    public static final String BRAND = "fiat";
    public static final String MODEL = "palio";
    public static final Double PRICE = 4545454D;
    public static final Long ID = 1L;
    private CarRepository carRepository;
    private CarRepository carRepositoryFail;
    private CarAction carAction;
    private CarResponse carResponse;
    private CarAction carActionFail;

    @Before
    public void init(){

        carRepositoryFail = new CarRepository() {
            @Override
            public <S extends Car> S save(S s) {
                return null;
            }

            @Override
            public <S extends Car> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Car> findById(Long aLong) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Car> findAll() {
                return null;
            }

            @Override
            public Iterable<Car> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Car car) {

            }

            @Override
            public void deleteAll(Iterable<? extends Car> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };

        carRepository = new CarRepository() {
            @Override
            public <S extends Car> S save(S s) {
                return null;
            }

            @Override
            public <S extends Car> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Car> findById(Long aLong) {
                Car car = new Car(ID, BRAND, MODEL, PRICE);
                return Optional.of(car);
            }

            @Override
            public boolean existsById(Long aLong) {
                return false;
            }

            @Override
            public Iterable<Car> findAll() {
                return null;
            }

            @Override
            public Iterable<Car> findAllById(Iterable<Long> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Long aLong) {

            }

            @Override
            public void delete(Car car) {

            }

            @Override
            public void deleteAll(Iterable<? extends Car> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };

    }

    @Test
    public void shouldThowException(){
        givenFailedCarAction();
        try{
            whenFindCarWithIdFour();
        }catch (NotFoundExecption notFoundExecption){
            thenSouldThrowException(notFoundExecption);
            return;
        }
        Assert.fail();

    }

    private void thenSouldThrowException(NotFoundExecption notFoundExecption) {
        Assert.assertEquals("car id 4 not found ",notFoundExecption.getMessage());
    }

    private void whenFindCarWithIdFour() {
        carActionFail.getCarById(4L);
    }

    private void givenFailedCarAction() {
        carActionFail = new CarAction(carRepositoryFail);
    }


    @Test
    public void shouldFindIdOne(){
        givenACarAction();
        whenFindIdOne();
        thenMustFindIdOne();
    }

    private void thenMustFindIdOne() {
        Assert.assertEquals(ID,carResponse.getId());
        Assert.assertEquals(BRAND,carResponse.getBrand());
        Assert.assertEquals(MODEL,carResponse.getModel());
        Assert.assertEquals(PRICE,carResponse.getPrice());
    }

    private void whenFindIdOne() {
        carResponse = carAction.getCarById(1L);
    }

    private void givenACarAction() {
        carAction = new CarAction(carRepository);
    }


}
