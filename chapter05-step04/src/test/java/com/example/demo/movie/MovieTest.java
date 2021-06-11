package com.example.demo.movie;

import com.example.demo.money.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    void calculateMovieFeeTest() {

        //given
        DiscountCondition discountCondition = new SequenceCondition(3);
        AmountDiscountMovie movie = new AmountDiscountMovie(
                "반지의제왕",
                Duration.ofHours(1),
                Money.wons(12000),
                Money.wons(1000),
                discountCondition);
        Screening screening = new Screening(movie, 3,
                LocalDateTime.of(2021, 06, 02, 14, 00));
        Money expectedFee = Money.wons(11000);

        //when
        Money actualFee = movie.calculateMovieFee(screening);

        //then
        assertEquals(expectedFee, actualFee);
    }

}