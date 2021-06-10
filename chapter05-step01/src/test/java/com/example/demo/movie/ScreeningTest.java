package com.example.demo.movie;

import com.example.demo.money.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    @Test
    void reserveTest() {

        //given
        DiscountCondition discountCondition = new DiscountCondition(3);
        Movie movie = new Movie("반지의제왕", Duration.ofHours(1),
                Money.wons(12000),
                Money.wons(1000),
                discountCondition);

        Screening screening = new Screening(movie, 3,
                LocalDateTime.of(2021, 06, 02, 14, 00));

        Customer customer = new Customer("eddy", "123abc");

        //when
        Reservation reservation = screening.reserve(customer, 3);

        //then
        assertEquals(Money.wons(33000), reservation.getFee());
    }
}