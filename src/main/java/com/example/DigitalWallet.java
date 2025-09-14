package com.example;

public class DigitalWallet {
    private String owner;
    private double balance;
    private boolean verified;
    private boolean locked;

    public DigitalWallet(String owner, double initialBalance) {
        if (initialBalance < 0) {
            throw new IllegalArgumentException("Saldo inicial não pode ser negativo");
        }
        this.owner = owner;
        this.balance = initialBalance;
        this.verified = false;
        this.locked = false;
    }

    public String getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isVerified() {
        return verified;
    }

    public boolean isLocked() {
        return locked;
    }

    public void verify() {
        this.verified = true;
    }

    public void lock() {
        this.locked = true;
    }

    public void unlock() {
        this.locked = false;
    }

    
    public void deposit(double amount) {
        if (amount <= 0) {
            throw new IllegalArgumentException("Depósito deve ser maior que zero");
        }
        this.balance += amount;
    }
}
