package com.javatut;

import java.util.Date;

public class Loan {
    private Float amount;
    private Integer numberOfPeriods;
    private Date dateStart;

    public Loan() {
    }

    public Loan(Float amount, Integer numberOfPeriods, Date dateStart) {
        this.amount = amount;
        this.numberOfPeriods = numberOfPeriods;
        this.dateStart = dateStart;
    }


    public Date getDateStart() {
        return dateStart;
    }

    public Float getAmount() {
        return amount;
    }

    public Integer getNumberOfPeriods() {
        return numberOfPeriods;
    }
}