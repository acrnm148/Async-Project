package com.async.myapp.async.domain.order.service;

import com.async.myapp.async.domain.order.Orders;
import com.async.myapp.async.domain.order.repository.OrdersRepository;
import com.async.myapp.async.domain.order.service.listener.model.OrdersEvent;
import com.async.myapp.async.web.controller.order.requestDto.OrdersForm;
import com.async.myapp.async.web.exception.NoMoreThread;
import com.querydsl.core.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.concurrent.RejectedExecutionException;

@Service
@RequiredArgsConstructor
public class OrdersService {

    private final ApplicationEventPublisher publisher;
    private final OrdersRepository ordersRepository;

    public void createOrders(OrdersForm ordersForm) {
        // 주문 내역 저장
        Orders createdOrders = Orders.createOrders(ordersForm.userEmail, ordersForm.productName, ordersForm.price, ordersForm.count);
        ordersRepository.save(createdOrders);

        // 이벤트 발생
        try {
            publisher.publishEvent(OrdersEvent.builder()
                    .userEmail(createdOrders.getUserEmail())
                    .productName(createdOrders.getProductName())
                    .build());
        } catch(RejectedExecutionException e) {
            throw new NoMoreThread("쓰레드풀이 다찼음");
        }
    }
}
