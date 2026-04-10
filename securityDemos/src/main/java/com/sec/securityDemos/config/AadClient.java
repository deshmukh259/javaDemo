package com.sec.securityDemos.config;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "aad-client")
@Data
@Builder
@Getter
@Setter
public class AadClient {

    private String userId;
    private Connection connection;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(Connection connection) {
        this.connection = connection;
    }
//aad-client.userid=ABCD
    //aad-client.connection.secret=ZZXXX
    //aad-client.connection.uam=123wee
}





