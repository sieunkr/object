package com.example.demo.movie.pricing;

import com.example.demo.money.Money;
import com.example.demo.movie.DiscountPolicy;
import com.example.demo.movie.Screening;

public class NoneDiscountPolicy implements DiscountPolicy {
    @Override
    public Money calculateDiscountAmount(Screening screening) {
        return Money.ZERO;
    }
}
