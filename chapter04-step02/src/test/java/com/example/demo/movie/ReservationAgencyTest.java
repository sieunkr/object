package com.example.demo.movie;

import com.example.demo.money.Money;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationAgencyTest {

    @Test
    @DisplayName("")
    void ifAmountDiscountPolicy_reserveTest() {

        //given
        DiscountCondition discountCondition = new DiscountCondition(3);
        Movie movie = new Movie(
                "반지의제왕",
                Duration.ofHours(1),
                Money.wons(12000),
                Money.wons(1000),
                discountCondition);

        Screening screening = new Screening(movie, 3, LocalDateTime.of(2021, 06, 02, 14, 00));
        Customer customer = new Customer("eddy", "123abcdef");

        int expectedAudienceCount = 2;
        Money expectedFee = Money.wons(22000);

        //when
        Reservation actualReservation = new ReservationAgency()
                .reserve(screening, customer, 2);

        //then
        assertEquals(expectedAudienceCount, actualReservation.getAudienceCount());
        assertEquals(expectedFee, actualReservation.getFee());
    }

    @Test
    @DisplayName("")
    void ifPercentDiscountPolicy_reserveTest() {

        //given
        DiscountCondition discountCondition = new DiscountCondition(3);
        Movie movie = new Movie(
                "반지의제왕",
                Duration.ofHours(1),
                Money.wons(12000),
                0.1,
                discountCondition);

        Screening screening = new Screening(movie, 3, LocalDateTime.of(2021, 06, 02, 14, 00));
        Customer customer = new Customer("eddy", "123abcdef");

        int expectedAudienceCount = 2;
        Money expectedFee = Money.wons(21600);

        //when
        Reservation actualReservation = new ReservationAgency()
                .reserve(screening, customer, 2);

        //then
        assertEquals(expectedAudienceCount, actualReservation.getAudienceCount());
        assertEquals(expectedFee, actualReservation.getFee());
    }
}