package com.predoana.app.web.dao;

import java.util.Arrays;
import java.util.List;

public class JdbcUserDAO {

    public List<String> getAllUserNames() {
        System.out.println("** Getting usernames from RDBMS **");
        return Arrays.asList("Claudiu", "Mariana", "Laura");
    }
}
