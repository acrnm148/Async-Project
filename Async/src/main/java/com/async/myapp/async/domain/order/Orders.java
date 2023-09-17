package com.async.myapp.async.domain.order;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;

import java.time.LocalDateTime;

@Entity
@Getter
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String userEmail;

    private String productName;

    private String price;

    private String count;

    private LocalDateTime createdDate;

    public static Orders createOrders(String userEmail, String productName, String price, String count) {
        Orders newOrders = new Orders();
        newOrders.userEmail = userEmail;
        newOrders.productName = productName;
        newOrders.price = price;
        newOrders.count = count;
        newOrders.createdDate = LocalDateTime.now();
        return newOrders;
    }
}
