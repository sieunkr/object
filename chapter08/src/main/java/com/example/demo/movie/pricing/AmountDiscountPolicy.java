package com.example.demo.movie.pricing;


import com.example.demo.money.Money;
import com.example.demo.movie.DiscountCondition;
import com.example.demo.movie.DiscountPolicy;
import com.example.demo.movie.Screening;

public class AmountDiscountPolicy extends DiscountPolicy {
    private Money discountAmount;

    public AmountDiscountPolicy(Money discountAmount, DiscountCondition... conditions) {
        super(conditions);
        this.discountAmount = discountAmount;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return discountAmount;
    }
}
