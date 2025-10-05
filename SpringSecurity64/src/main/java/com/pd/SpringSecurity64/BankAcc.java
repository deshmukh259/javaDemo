package com.pd.SpringSecurity64;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

public class BankAcc {

    private final int id;
    private final String owner;
    private final String accNumber;
    private final int balance;


    public BankAcc(int id, String owner, String accNumber, int balance) {
        this.id = id;
        this.owner = owner;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    @PreAuthorize("this.owner == authentication?.name")
    @HandleAuthorizationDenied(handlerClass = MaskAuthorizationDeniedHandler.class)
    public String getAccNumber() {
        return accNumber;
    }

    public int getBalance() {
        return balance;
    }
}
