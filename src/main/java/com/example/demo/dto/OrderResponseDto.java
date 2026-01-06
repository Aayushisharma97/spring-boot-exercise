package com.example.demo.dto;

public class OrderResponseDto {

    private Long id;
    private String product;

    public OrderResponseDto() {
    }

    public OrderResponseDto(Long id, String product) {
        this.id = id;
        this.product = product;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }
}
