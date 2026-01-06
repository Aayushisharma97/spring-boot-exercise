package com.example.demo.dto;

import java.util.List;

public class UserResponseDto {

    private Long id;
    private String name;
    private String email;
    private List<OrderResponseDto> orders;

    public UserResponseDto() {
    }

    public UserResponseDto(Long id, String name, String email, List<OrderResponseDto> orders) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.orders = orders;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public List<OrderResponseDto> getOrders() {
        return orders;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setOrders(List<OrderResponseDto> orders) {
        this.orders = orders;
    }
}
