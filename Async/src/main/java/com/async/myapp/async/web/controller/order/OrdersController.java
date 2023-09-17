package com.async.myapp.async.web.controller.order;

import com.async.myapp.async.domain.order.service.OrdersService;
import com.async.myapp.async.web.controller.order.requestDto.OrdersForm;
import com.async.myapp.async.web.response.BaseResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/order")
public class OrdersController {

    private final OrdersService ordersService;

    @PostMapping("/create")
    public BaseResponse orderProduct(@RequestBody OrdersForm ordersForm) {
        log.info("OrderController.orderProduct: {}", ordersForm);

        ordersService.createOrders(ordersForm);

        return new BaseResponse("200", "주문이 접수되었습니다.");
    }
}
