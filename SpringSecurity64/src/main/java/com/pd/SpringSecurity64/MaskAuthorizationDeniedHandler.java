package com.pd.SpringSecurity64;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.authorization.AuthorizationResult;
import org.springframework.security.authorization.method.MethodAuthorizationDeniedHandler;
import org.springframework.security.authorization.method.MethodInvocationResult;
import org.springframework.stereotype.Component;

@Component
public class MaskAuthorizationDeniedHandler implements
        MethodAuthorizationDeniedHandler {
    @Override
    public Object handleDeniedInvocation(MethodInvocation methodInvocation, AuthorizationResult authorizationResult) {
        return "****";
    }


}
