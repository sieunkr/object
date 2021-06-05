package com.example.demo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AudienceTest {


    //더 작은 단위로 단위테스트가 가능함. 의존성을 최소화하면서 단위테스트

    @Test
    @DisplayName("")
    void buyTest() {

        //given
        long beforeEnteringBagAmount = 30000;
        long ticketFee = 12000;
        long expectedAfterEnteringBagAmount = 18000;

        Bag bag = new Bag(beforeEnteringBagAmount);
        Audience audience = new Audience(bag);
        Ticket ticket = new Ticket(ticketFee);

        //when
        audience.buy(ticket);

        //then
        assertEquals(expectedAfterEnteringBagAmount, audience.getBag().getAmount());
    }
}