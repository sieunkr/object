package com.example.demo.movie.pricing;


import com.example.demo.movie.DiscountCondition;
import com.example.demo.movie.Screening;

public class SequenceCondition implements DiscountCondition {
    private int sequence;

    public SequenceCondition(int sequence) {
        this.sequence = sequence;
    }

    public boolean isSatisfiedBy(Screening screening) {
        return screening.isSequence(sequence);
    }
}
