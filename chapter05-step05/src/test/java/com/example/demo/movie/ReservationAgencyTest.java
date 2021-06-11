package com.example.demo.movie;

import com.example.demo.money.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ReservationAgencyTest {

    @Test
    void reserveTest() {

        //given
        ReservationAgency agency = new ReservationAgency();
        DiscountCondition discountCondition = new DiscountCondition(3);
        Movie movie = new Movie(
                "반지의제왕",
                Duration.ofHours(1),
                Money.wons(12000),
                Money.wons(1000),
                discountCondition);
        Screening screening = new Screening(movie, 3,
                LocalDateTime.of(2021, 06, 02, 14, 00));
        Customer customer = new Customer("eddy", "123abc");
        Money expectedFee = Money.wons(55000);

        //when
        Reservation actualReservation = agency.reserve(screening, customer, 5);

        //then
        assertEquals(5, actualReservation.getAudienceCount());
        assertEquals(expectedFee, actualReservation.getFee());


    }


}