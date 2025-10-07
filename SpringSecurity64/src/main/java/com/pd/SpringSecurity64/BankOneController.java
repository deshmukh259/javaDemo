package com.pd.SpringSecurity64;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BankOneController {


    final BankAccInterface bankAccInterface;

    public BankOneController(BankAccInterface bankAccInterface) {
        this.bankAccInterface = bankAccInterface;
    }

    @GetMapping("/account/{id}")
    BankAcc findById(@PathVariable Integer id){
        return bankAccInterface.findById(id);
    }

}
