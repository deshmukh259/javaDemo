package com.pd.SpringSecurity64;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authorization.AuthorizationDeniedException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import static org.junit.jupiter.api.Assertions.*;

class BankAccImplTest {

    BankAccInterface bankAcc = new BankAccountSrviceProxy(new BankAccImpl());


    void login(String user){
        Authentication auth = new TestingAuthenticationToken(user,"password","ROLE_USER");
        SecurityContextHolder.getContext().setAuthentication(auth);


    }

    @AfterEach
    void cleanUp(){
        SecurityContextHolder.clearContext();
    }

@Test
void findByIdWhenGranted() {
    login("Abc");
    this.bankAcc.findById(1);
}


    @Test
    void getById() {
        login("Abc");
        this.bankAcc.getById(1);
    }


    @Test
    void findByIdWhenDenied() {
        login("Jo");
        assertThrows(AuthorizationDeniedException.class,()->this.bankAcc.findById(1));
    }    @Test
    void getByIdWhenDenied() {
        login("Jo");
        assertThrows(AuthorizationDeniedException.class,()->this.bankAcc.getById(1));
    }
}