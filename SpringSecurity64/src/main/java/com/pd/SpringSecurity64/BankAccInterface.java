package com.pd.SpringSecurity64;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authorization.method.HandleAuthorizationDenied;

public interface BankAccInterface {
    @PostReadBankAccount
    BankAcc findById(int id);

    @PostReadBankAccount
    BankAcc getById(int id);

    @PreWriteBankAccount("toSave")
    //@PreAuthorize("#toSave?.owner == authentication?.name")
    void save(BankAcc toSave);

    @PreWriteBankAccount("toUpdate")
    //@HandleAuthorizationDenied(handlerClass = MaskAuthorizationDeniedHandler.class)
    void update(BankAcc toUpdate);
}
