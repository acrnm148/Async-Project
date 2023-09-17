package com.async.myapp.async.domain.order.service.listener.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class OrdersEvent {
    private String userEmail;
    private String productName;
}
