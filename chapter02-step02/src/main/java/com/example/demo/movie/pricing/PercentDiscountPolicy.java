package com.example.demo.movie.pricing;

import com.example.demo.money.Money;
import com.example.demo.movie.DefaultDiscountPolicy;
import com.example.demo.movie.DiscountCondition;
import com.example.demo.movie.Screening;

public class PercentDiscountPolicy extends DefaultDiscountPolicy {

    private double percent;

    public PercentDiscountPolicy(double percent, DiscountCondition... conditions) {
        super(conditions);
        this.percent = percent;
    }

    @Override
    protected Money getDiscountAmount(Screening screening) {
        return screening.getMovieFee().times(percent);
    }
}
