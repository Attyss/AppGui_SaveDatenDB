package com.amorettyss.model;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {          //here you have to update with you data resource
    private final String base = "xxxx";
    private final String user = "xxxx";
    private final String password = "xxxx";
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public java.sql.Connection getConnect(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(this.url, this.user, this.password);
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
        return con;
    }
}
