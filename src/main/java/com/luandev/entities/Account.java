package com.luandev.entities;

import com.luandev.domainException.NotEnoughBalanceException;
import com.luandev.domainException.NumInvalidException;

import java.rmi.AccessException;

public class Account {
    private Integer number;
    private String holder;
    private Double balance;
    private final Double withdrawLimit;

    public Account(Integer number, String holder, Double balance, Double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public Double getBalance() {
        return balance;
    }

    public Double getWithdrawLimit() {
        return withdrawLimit;
    }


    public void deposit(double amount) throws NumInvalidException {
        if (amount > 0) {
            balance += amount;
        } else {
            throw new NumInvalidException("Invalid deposit amount.");
        }
    }

    public void withdraw(double amount) throws AccessException, NotEnoughBalanceException {
        if (amount > 0 && amount > withdrawLimit){
            throw new AccessException("The amount exceeds withdraw limit.");
        }

        if (amount > 0 && amount > balance){
            throw new NotEnoughBalanceException("Not enough balance.");
        }
        balance -= amount;
    }
}
