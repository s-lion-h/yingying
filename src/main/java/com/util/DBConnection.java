package com.util;

import java.sql.*;
public class DBConnection {
    private static String url="jdbc:mysql://120.77.80.58:3306/stock1.1?user=root&password=123456&characterEncoding=utf-8&useSSL=true";
    private static String driverName="com.mysql.jdbc.Driver";
    static{
        try{
            Class.forName(driverName);
        }catch (ClassNotFoundException e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            Connection conn=DriverManager.getConnection(url);
            return conn;
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }
    }
    public static void free(Connection conn,Statement stmt,ResultSet rs){
        try{
            if(rs!=null){
                rs.close();
            }
        }catch (SQLException e) {
            // TODO: handle exception
            e.printStackTrace();
        }finally{
            try {
                if(stmt!=null)
                    stmt.close();
            } catch (SQLException e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }finally{
                try {
                    if(conn!=null)
                        conn.close();
                } catch (SQLException e3) {
                    // TODO: handle exception
                    e3.printStackTrace();
                }
            }
        }
    }
}
