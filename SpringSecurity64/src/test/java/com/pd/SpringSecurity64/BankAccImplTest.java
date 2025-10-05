package com.pd.SpringSecurity64;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.authorization.AuthorizationProxyFactory;
import org.springframework.security.authorization.method.AuthorizationAdvisorProxyFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class BankAccImplTest {

    @Autowired
    BankAccInterface bankAcc;


    @Test
    @WithMockAbc
    void findByIdWhenGranted() {
        this.bankAcc.findById(1);
    }


    @Test
    @WithMockAbc
    void getById() {
        this.bankAcc.getById(1);
    }


    @Test
    @WithMockJo
    void findByIdWhenDenied() {
        assertThrows(AuthorizationDeniedException.class, () -> this.bankAcc.findById(1));
    }

    @Test
    @WithMockJo
    void getByIdWhenDenied() {
        assertThrows(AuthorizationDeniedException.class, () -> this.bankAcc.getById(1));
    }

    @Test
    @WithMockAccountant
    void findByIdAccountant() {
        this.bankAcc.findById(1);

    }

    @Test
    @WithMockAccountant
    void getAccountNumberWhenAccountant(){
        var byId = this.bankAcc.getById(1);
        assertEquals("****",byId.getAccNumber());
    }

    @Test
    @WithMockAbc
    void getAccountNumberWithAbc(){
        var byId = this.bankAcc.getById(1);
        assertEquals("12345",byId.getAccNumber());
    }

    @Test
    @WithMockAbc
    void saveAccountAbc(){

        BankAcc acc = new BankAcc(1,"Abc","123",444);
        this.bankAcc.save(acc);
    }

    @Test
    void updateDeniedWhenJo(){

        BankAcc acc = new BankAcc(1,"Jo","233",33);

        assertThrows(AuthorizationDeniedException.class,()->this.bankAcc.update(acc));

    }

}