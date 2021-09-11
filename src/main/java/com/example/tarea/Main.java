package com.example.tarea;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(
                    "jdbc:mysql://wcwimj6zu5aaddlj.cbetxkdyhwsb.us-east-1.rds.amazonaws.com:3306/pure9fzm2r51wzt2",
                    "v6qpcjf31wwq29bl",
                    "ykehurgeiujmfsmz");
            Statement stmt=con.createStatement();
            ResultSet rs=stmt.executeQuery("select * from empleados");
            while(rs.next())
                System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));
            con.close();
        }catch(Exception e){ System.out.println(e);}
    }
}
