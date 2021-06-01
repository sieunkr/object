package com.example.demo.movie;

import com.example.demo.money.Money;

public interface DiscountPolicy {
    Money calculateDiscountAmount(Screening screening);
}
