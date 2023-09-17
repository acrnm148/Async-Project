package com.async.myapp.async.domain.order.repository;

import com.async.myapp.async.domain.order.Orders;
import com.async.myapp.async.domain.order.QOrders;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;

@Repository
@NoArgsConstructor
@Transactional(readOnly = true)
public class OrdersRepository {

    private EntityManager em;
    private JPAQueryFactory query;

    private QOrders o1 = new QOrders("o1");

    @Autowired
    public OrdersRepository(EntityManager em) {
        this.em = em;
        this.query = new JPAQueryFactory(em);
    }

    //주문 저장
    @Transactional
    public void save(Orders orders) {
        em.persist(orders);
    }

    //고유ID로 주문 조회
    public Orders findOrders(Long orderId) {
        return em.find(Orders.class, orderId);
    }

    //사용자 ID로 주문 조회
    public List<Orders> findOrdersByUserEmail(String userEmail) {
        return query.selectFrom(o1)
                .where(userEmailEq(userEmail))
                .fetch();
    }

    private BooleanExpression userEmailEq(String userEmail) {
        if (Objects.isNull(userEmail)) {
            return null;
        }
        return QOrders.orders.userEmail.eq(userEmail);
    }
}
