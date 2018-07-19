package com.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


public class DBProcess {
    private Connection conn=null;
    private Statement st=null;
    private PreparedStatement pst=null;
    private ResultSet rs=null;


    public boolean insertDeleteUpdate(String sql){
        boolean flag=true;
        conn=DBConnection.getConnection();
        if(conn==null)return false;
        try{
            st=conn.createStatement();
            st.executeUpdate(sql);
        }catch(SQLException e){
            e.printStackTrace();
            flag=false;
        }finally{
            DBConnection.free (conn,st,rs);
        }
        return flag;
    }

    public boolean queryReturnboolean(String sql){
        boolean flag=true;
        conn=DBConnection.getConnection();
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            if(!rs.next())flag=false;
        }catch(SQLException e){
            e.printStackTrace();
            flag=false;
        }finally{
            DBConnection. free (conn, st, rs);
        }
        return flag;
    }

    public ArrayList queryReturnList(String sql){
        ArrayList al=new ArrayList();
        String colname[];
        int columns;
        ResultSetMetaData rsmd=null;
        conn=DBConnection.getConnection();
        if(conn==null)return al;
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
            rsmd=rs.getMetaData();
            columns=rsmd.getColumnCount();
            colname=new String[columns];
            for(int i=1;i<=columns;i++){
                colname[i-1]=rsmd.getColumnName(i);
            }
            ArrayList al_colname=new ArrayList();
            for(int i=1;i<=columns;i++){
                al_colname.add(colname[i-1]);
            }
            al.add(al_colname);
            while(rs.next()){
                ArrayList alrow=new ArrayList();
                for(int i=1;i<=columns;i++)
                    alrow.add(rs.getString(colname[i-1]));
                al.add(alrow);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection. free (conn, st, rs);
        }
        return al;
    }

    public int rowCount(String tablename){
        int num=0;
        conn=DBConnection.getConnection();
        try{
            st=conn.createStatement();
            rs=st.executeQuery("select count(*) from " +tablename);
            rs.next();
            num=rs.getInt(1);
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            DBConnection.free(conn,st,rs);
        }
        return num;
    }

    public ResultSet queryReturnSet(String sql){
        conn=DBConnection.getConnection();
        try{
            st=conn.createStatement();
            rs=st.executeQuery(sql);
        }catch(SQLException e){
            e.printStackTrace();
        }
        return rs;
    }

}
