package com.pd.junitDemoSecurity2;

import jakarta.persistence.*;

@Entity
@Table(name = "authority")
public class AuthorityD {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name= "user_name",
            referencedColumnName = "user_name",
            nullable = false)
    private  MyUser user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MyUser getUser() {
        return user;
    }

    public void setUser(MyUser user) {
        this.user = user;
    }
}
