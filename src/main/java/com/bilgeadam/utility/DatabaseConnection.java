package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {


    private  static  DatabaseConnection  instance;
    private  static final String username="postgres";
    private  static final String password="root";
    private  static final String dbname="futbolAppDb";
    private  static final String url="jdbc:postgresql://localhost:5858/"+dbname;

    private  static  Connection connection;



    private DatabaseConnection(){

    }

    public  static  DatabaseConnection getInstance(){
        if(instance==null){
            instance= new DatabaseConnection();
        }
        return  instance;
    }


    public  Connection getConnection() throws Exception {
        connection= DriverManager.getConnection(url,username,password);
        return  connection;
    }
}
