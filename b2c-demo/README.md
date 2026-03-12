# This is B2c connect demo 

    Here I have created new service with just thymleaf with 1 html page to display
    And then added spring security and added some basic endpoint to redirect request with defualt passwword

# B2c application

    I have created tenants and register app in azure portal
    Create sample user and add to app registration


![img.png](img.png)

![img_1.png](img_1.png)

![img_2.png](img_2.png)

![img_3.png](img_3.png)

This is optional . this used in verify role. when we have backend and  FE diffrent

![img_4.png](img_4.png)


permit authentication api with toke

      auth.requestMatchers("/","/time","/login", "/login/oauth2/code/**","/login/oauth2/code/azure").permitAll()

Authentication endpoint to get code

        .authenticationEntryPoint(
                        new LoginUrlAuthenticationEntryPoint("/oauth2/authorization/azure")
                )

Success to home

             .oauth2Login(oauth2 -> oauth2
                        .defaultSuccessUrl("/home", true)



Application yml

              security:
                oauth2:
                  client:
                    registration:
                      azure:
                        client-id: ${CLIENTID}
                        client-secret: ${CLIENTSECRET}
                        authorization-grant-type: authorization_code
                        scope:
                          - openid
                          - profile
                          - User.Read
                          - email
                          - offline_access
                        redirect-uri: "{baseUrl}/login/oauth2/code/{registrationId}"
                        provider: azure
                    provider:
                      azure:
                        issuer-uri: https://login.microsoftonline.com/${TENANT}/v2.0