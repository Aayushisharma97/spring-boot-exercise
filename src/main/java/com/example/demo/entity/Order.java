package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // Constructors
    public Order() {
    }

    public Order(Long id, String product, User user) {
        this.id = id;
        this.product = product;
        this.user = user;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getProduct() {
        return product;
    }

    public User getUser() {
        return user;
    }

    // Setters
    public void setId(Long id) {
        this.id = id;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
