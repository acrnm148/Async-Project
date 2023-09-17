package com.async.myapp.async.domain.order.service.listener;

import com.async.myapp.async.domain.order.service.listener.model.OrdersEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class OrdersEventListener {

    @Async
    @EventListener
    public void sendPush(OrdersEvent event) {
        log.info("푸시 메시지 발송 - {}님, [상품명: {}] 주문 접수되었습니다.", event.getUserEmail(), event.getProductName());
    }

    @Async
    @EventListener
    public void sendMail(OrdersEvent event) {
        log.info("메일 전송 - {}님, [상품명: {}] 주문 접수되었습니다.", event.getUserEmail(), event.getProductName());
    }
}
