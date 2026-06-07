package com.pd.springJdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
public class Tserv {

@Autowired
    private JdbcTemplate jdbcTemplate;

    @Transactional
    public void extracted(int finalI) {
        System.out.println(Thread.currentThread() +" SpringJdbcTemplateApplication.ap1 "+ finalI);
        List<Map<String,Object>> dataMap = jdbcTemplate.queryForList("select * from public.seat_allocation where user_id is null order by id limit 1 for update");
        //System.out.println("dataMap.get(\"id\") = " + dataMap.getFirst().get("id"));
        jdbcTemplate.update("update public.seat_allocation set user_id = " + finalI + " where id="+dataMap.getFirst().get("id"));
    }
}
