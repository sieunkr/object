package com.example.demo.movie;

import com.example.demo.money.Money;
import com.example.demo.movie.pricing.AmountDiscountPolicy;
import com.example.demo.movie.pricing.SequenceCondition;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ScreeningTest {

    // 오브젝트 40page
    @Test
    @DisplayName("영화 예매 검증")
    void reserveTest() {

        //given

        int sequence = 10;
        Movie movie = getMovieBySequenceAndDiscountAmount(sequence, Money.wons(10000), Money.wons(800));
        Screening screening = new Screening(movie, sequence, LocalDateTime.now());
        int audienceCount = 2;
        Money expectedDiscountedFee = Money.wons(18400);

        //when
        Reservation reservation = screening.reserve(getCustomer(), audienceCount);

        //then
        assertEquals(expectedDiscountedFee, reservation.getFee());
    }

    private Movie getMovieBySequenceAndDiscountAmount(int sequence, Money fee, Money discountAmount) {
        String title = "아바타";
        Duration runningTime = Duration.ofHours(1);
        DiscountCondition discountCondition = new SequenceCondition(sequence);
        DiscountPolicy discountPolicy = new AmountDiscountPolicy(discountAmount, discountCondition);
        return new Movie(title, runningTime, fee, discountPolicy);
    }

    private Customer getCustomer() {
        return new Customer("eddy", "123abc");
    }
}