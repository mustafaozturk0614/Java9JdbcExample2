package com.bilgeadam.utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;

public class ConnectionProvider {

    private  PreparedStatement preparedStatement;



    //ctrl alt t try catch otamatik sarmalaması için
    public Optional<Connection> openConnection(){
        try {
        Connection connection= DatabaseConnection.getInstance().getConnection();
            System.out.println("veritabanına bağlanıldı");
            return  Optional.of(connection);
        } catch (Exception e) {
            System.out.println("veritabanına  bağlanılamadı !!!!!!");
            e.printStackTrace();
            return  Optional.empty();
        }
    }

    public  void closeConnection(){
        try {
            if (!DatabaseConnection.getInstance().getConnection().isClosed()){
                DatabaseConnection.getInstance().getConnection().close();
                System.out.println("Bağlantı sonlandırıldı");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public PreparedStatement getPreparedStatement(String sql){
        Optional<Connection> connection=openConnection();

        if (connection.isPresent()){
            try {
                preparedStatement=connection.get().prepareStatement(sql);
            } catch (SQLException e) {

                throw new RuntimeException(e);
            }
        }
        return  preparedStatement;
    }


}
