package com.pd.SpringSecurity64;

public interface BankAccInterface {
    @PostReadBankAccount
    BankAcc findById(int id);

    @PostReadBankAccount
    BankAcc getById(int id);
}
