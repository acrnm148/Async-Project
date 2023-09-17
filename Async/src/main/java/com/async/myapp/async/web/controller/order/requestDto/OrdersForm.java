package com.async.myapp.async.web.controller.order.requestDto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrdersForm {
    public String productName;
    public String price;
    public String count;
    public String userEmail;
}
