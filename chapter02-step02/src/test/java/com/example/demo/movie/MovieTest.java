package com.example.demo.movie;

import com.example.demo.money.Money;
import com.example.demo.movie.pricing.AmountDiscountPolicy;
import com.example.demo.movie.pricing.PercentDiscountPolicy;
import com.example.demo.movie.pricing.SequenceCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    @Test
    @DisplayName("요금 할인 정책인 경우, 요금 계산 검증")
    void ifAmountDiscountPolicy_calculateMovieFeeTest() {

        //given
        String title = "아바타";
        Duration runningTime = Duration.ofHours(1);
        Money fee = Money.wons(10000);
        Money discountAmount = Money.wons(800);
        Money expectedDiscountedFee = Money.wons(9200); //800원 할인해서
        DiscountCondition discountCondition = new SequenceCondition(10);
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(discountAmount, discountCondition);

        Movie movie = new Movie(title, runningTime, fee, discountPolicy);

        Screening screening = new Screening(movie, 10, LocalDateTime.now());


        //when
        Money actualDiscountedFee = movie.calculateMovieFee(screening);

        //then
        assertEquals(expectedDiscountedFee, actualDiscountedFee);
    }

    @Test
    @DisplayName("퍼센트 할인 정책인 경우, 요금 계산 검증")
    void ifPercentDiscountPolicy_calculateMovieFeeTest() {

        String title = "반지의제왕";
        Duration runningTime = Duration.ofHours(1);
        Money fee = Money.wons(11000);
        double percent = 0.1;
        Money expectedDiscountFee = Money.wons(9900);   //0.1% 프로 할인 해서
        DiscountCondition discountCondition = new SequenceCondition(3);
        DiscountPolicy discountPolicy = new PercentDiscountPolicy(percent, discountCondition);

        Movie movie = new Movie(title, runningTime, fee, discountPolicy);

        Screening screening = new Screening(movie, 3, LocalDateTime.now());

        //when
        Money actualDiscountedFee = movie.calculateMovieFee(screening);

        //then
        assertEquals(expectedDiscountFee, actualDiscountedFee);
    }

    @Test
    @DisplayName("할인 조건이 맞지 않을 때, 요금 계산 검증")
    void ifNoConditions_calculateMovieFeeTest() {

        //given
        String title = "반지의제왕";
        Duration runningTime = Duration.ofHours(1);
        Money fee = Money.wons(11000);
        Money expectedDiscountFee = fee;    //할인 없이 동일함..
        Money discountAmount = Money.wons(1000);
        DiscountCondition discountCondition = new SequenceCondition(3);
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(discountAmount, discountCondition);

        Movie movie = new Movie(title, runningTime, fee, discountPolicy);

        Screening screening = new Screening(movie, 2, LocalDateTime.now());


        //when
        Money actualDiscountedFee = movie.calculateMovieFee(screening);

        //then
        assertEquals(expectedDiscountFee, actualDiscountedFee);
    }

}