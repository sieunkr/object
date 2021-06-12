package com.example.demo.movie;

import com.example.demo.money.Money;
import com.example.demo.movie.pricing.AmountDiscountPolicy;
import com.example.demo.movie.pricing.OverlappedDiscountPolicy;
import com.example.demo.movie.pricing.PercentDiscountPolicy;
import com.example.demo.movie.pricing.SequenceCondition;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {


    //TODO: 동작 안함....
    @Test
    void reserveTest() {

        //given
        DiscountCondition discountCondition = new SequenceCondition(3);
        DiscountPolicy discountPolicy01 = new AmountDiscountPolicy(
                Money.wons(1000),
                discountCondition);
        DiscountPolicy discountPolicy02 = new PercentDiscountPolicy(
                0.1,
                discountCondition);

        OverlappedDiscountPolicy overlappedDiscountPolicy = new OverlappedDiscountPolicy(discountPolicy01, discountPolicy02);

        Movie movie = new Movie("반지의제왕", Duration.ofHours(1), Money.wons(12000), overlappedDiscountPolicy);

        Screening screening = new Screening(movie, 3,
                LocalDateTime.of(2021, 06, 02, 14, 00));
        Customer customer = new Customer("eddy", "123abc");

        Money expectedFee = Money.wons(10000);

        //when
        Reservation actualReservation = screening.reserve(customer, 1);

        //then
        assertEquals(expectedFee, actualReservation.getFee());
    }

}