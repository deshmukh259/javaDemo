package com.pd.junitDemoSecurity2;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepo extends JpaRepository<MyUser,Integer> {


    MyUser findByUserName(String userName);
}
