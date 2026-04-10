package com.pd.junitDemoSecurity2.sceu;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.authority.AuthorityUtils;

public class RobotAuthToken extends AbstractAuthenticationToken {

    public RobotAuthToken() {
        super(AuthorityUtils.createAuthorityList("ROLE_robot"));
    }

    @Override
    public boolean isAuthenticated() {
        return true;
    }

    @Override
    public void setAuthenticated(boolean authenticated) {
        throw new RuntimeException("--not allowed--");
    }

    @Override
    public Object getCredentials() {
        return null;
    }


    @Override
    public Object getPrincipal() {
        return "robot";
    }
}
