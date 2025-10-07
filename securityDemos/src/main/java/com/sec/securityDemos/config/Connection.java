package com.sec.securityDemos.config;

public class Connection {

    private String secret;
    private String uam;
    private Xcc xcc;

    @Override
    public String toString() {
        return "Connection{" +
                "secret='" + secret + '\'' +
                ", uam='" + uam + '\'' +
                '}';
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public String getUam() {
        return uam;
    }

    public void setUam(String uam) {
        this.uam = uam;
    }

    public Xcc getXcc() {
        return xcc;
    }

    public void setXcc(Xcc xcc) {
        this.xcc = xcc;
    }
}