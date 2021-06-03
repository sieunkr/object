package com.example.demo.money;

import java.time.DayOfWeek;
import java.time.LocalTime;

public class DiscountCondition {

    private DiscountConditionType type;
    private int sequence;

    private DayOfWeek dayOfWeek;
    private LocalTime startTime;
    private LocalTime endTime;

    public DiscountConditionType getType() {
        return type;
    }



}
