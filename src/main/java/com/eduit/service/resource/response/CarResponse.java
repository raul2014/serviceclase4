package com.eduit.service.resource.response;

public class CarResponse {

    private Long id;
    private String brand;
    private String model;
    private Double price;

    public CarResponse(Long id, String brand, String model, Double price) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Double getPrice() {
        return price;
    }
}
