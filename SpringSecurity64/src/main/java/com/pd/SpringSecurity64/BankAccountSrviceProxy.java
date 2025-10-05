package com.pd.SpringSecurity64;


import org.springframework.security.authorization.AuthorizationDecision;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.security.Principal;

public class BankAccountSrviceProxy implements BankAccInterface {

    final BankAccInterface delegate;

    public BankAccountSrviceProxy(BankAccInterface delegate) {
        this.delegate = delegate;
    }

    @Override
    public BankAcc findById(int id) {
        BankAcc acc = delegate.findById(id);
        Principal principal = SecurityContextHolder.getContext().getAuthentication();

        if (!principal.getName().equals(acc.getOwner())) {
            throw new AuthorizationDeniedException("Invalid user", new AuthorizationDecision(false));
        }
        return acc;
    }

    @Override
    public BankAcc getById(int id) {
        BankAcc acc = delegate.getById(id);
        Principal principal = SecurityContextHolder.getContext().getAuthentication();
        if (!principal.getName().equals(acc.getOwner())) {
            throw new AuthorizationDeniedException("Invalid user", new AuthorizationDecision(false));
        }
        return acc;
    }


}
