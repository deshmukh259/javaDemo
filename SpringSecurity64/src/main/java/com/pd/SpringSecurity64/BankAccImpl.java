package com.pd.SpringSecurity64;

import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public final class BankAccImpl implements BankAccInterface {


    @Override
    public BankAcc findById(int id) {
        BankAcc acc = new BankAcc(1, "Abc", "12345", 100);
        return acc;

    }

    @Override
    public BankAcc getById(int id) {
        return findById(id);
    }
}
