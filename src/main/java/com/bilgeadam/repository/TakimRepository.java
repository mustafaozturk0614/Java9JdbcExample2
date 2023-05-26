package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Takim;
import com.bilgeadam.utility.ConnectionProvider;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class TakimRepository implements  ICrud<Takim> {
    private  String sql="";

    private ConnectionProvider connectionProvider;

    public TakimRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Takim takim) {
        sql="insert into takim(isim) values(?)";
        try {
            PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
            preparedStatement.setString(1,takim.getIsim());
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Takim takim) {



    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<Takim> findAll() {
        return null;
    }

    @Override
    public Optional<Takim> findById(Long id) {
        return Optional.empty();
    }
}
