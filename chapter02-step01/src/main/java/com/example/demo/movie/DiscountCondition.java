package com.example.demo.movie;

public interface DiscountCondition {
    boolean isSatisfiedBy(Screening screening);
}