package com.example.demo.movie;

import com.example.demo.money.Money;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Collections;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    @Test
    void calculateMovieFeeTest() {

        //given
        DiscountCondition discountCondition = new SequenceCondition(3);
        Movie movie = new AmountDiscountMovie(
                "반지의제왕",
                Duration.ofHours(1),
                Money.wons(12000),
                Money.wons(1000),
                discountCondition);

        //Movie 추상클래스에 의존함 164페이지 확인
        Screening screening = new Screening(movie, 3,
                LocalDateTime.of(2021, 06, 02, 14, 00));
        Money expectedFee = Money.wons(11000);

        //when
        Money actualFee = movie.calculateMovieFee(screening);

        //then
        assertEquals(expectedFee, actualFee);
    }
}