package com.example.springbasic.order;

public interface OrderService {
    Order creatOrder(Long memberId, String itemName, int itemPrice);
}
