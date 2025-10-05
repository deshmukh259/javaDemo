package com.pd.SpringSecurity64;

import org.springframework.security.access.prepost.PreAuthorize;

public interface BankAccInterface {
    @PostReadBankAccount
    BankAcc findById(int id);

    @PostReadBankAccount
    BankAcc getById(int id);

    @PreWriteBankAccount("toSave")
    //@PreAuthorize("#toSave?.owner == authentication?.name")
    void save(BankAcc toSave);

    @PreWriteBankAccount("toUpdate")
    void update(BankAcc toUpdate);
}
