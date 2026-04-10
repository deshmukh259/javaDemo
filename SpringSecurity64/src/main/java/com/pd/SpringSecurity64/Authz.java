package com.pd.SpringSecurity64;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import static org.springframework.security.authorization.AuthorityReactiveAuthorizationManager.hasRole;

@Component
public class Authz {

    public boolean check(Authentication authentication, BankAcc bankAcc) {

        if (authentication.getName().equals(bankAcc.getOwner())) {
            return true;
        } else {

            return hasRole("ACCOUNTANT").check(() -> authentication), bankAcc).isGranted();
        }

        return false;
    }
}
