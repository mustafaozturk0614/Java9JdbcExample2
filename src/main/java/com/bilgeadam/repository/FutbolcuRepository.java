package com.bilgeadam.repository;

import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.utility.ConnectionProvider;
import com.bilgeadam.utility.DatabaseConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FutbolcuRepository implements ICrud<Futbolcu> {

    private  String sql="";

    private ConnectionProvider connectionProvider;

    public FutbolcuRepository(ConnectionProvider connectionProvider) {
        this.connectionProvider = connectionProvider;
    }

    @Override
    public void save(Futbolcu futbolcu) {
        sql="Insert into futbolcu(isim,mevki,forma_no,deger,takim_id) values('"+futbolcu.getIsim()+"','"+
                futbolcu.getMevki()+"',"+futbolcu.getFormaNo()+","+futbolcu.getDeger()+","+futbolcu.getTakimId()+")";

        try {
            PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Futbolcu futbolcu) {
        sql="update futbolcu set isim=?,mevki=?,forma_no=?,deger=?,takim_id=? where id=?";
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.setString(1,futbolcu.getIsim());
            preparedStatement.setString(2, futbolcu.getMevki());
            preparedStatement.setInt(3,futbolcu.getFormaNo());
            preparedStatement.setLong(4,futbolcu.getDeger());
            preparedStatement.setLong(5,futbolcu.getTakimId());
            preparedStatement.setLong(6,futbolcu.getId());
            int count=preparedStatement.executeUpdate();
            if (count>0){
                System.out.println("Güncelleme Başarılı");
            }else{
                System.out.println("Güncelleme Başarısız!!!");
            }
            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


    }

    @Override
    public void delete(Long id) {
        sql="delete from futbolcu where id="+id;
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            preparedStatement.executeUpdate();
            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Futbolcu> findAll() {
        List<Futbolcu> futbolcuList=new ArrayList<>();
        sql="select * from futbolcu";
        PreparedStatement preparedStatement= connectionProvider.getPreparedStatement(sql);
        try {
            ResultSet resultSet=preparedStatement.executeQuery();
            while ( resultSet.next()){
//                Futbolcu futbolcu=new Futbolcu();
//                futbolcu.setId(resultSet.getLong(1));
                Long id= resultSet.getLong(1);
                String isim=resultSet.getString(2);
                String mevki=resultSet.getString("mevki");
                Long deger= resultSet.getLong("deger");
                int formaNo=resultSet.getInt("forma_no");
                Long takimId=resultSet.getLong("takim_id");
                futbolcuList.add(Futbolcu.builder()
                                .id(id)
                                .takimId(takimId)
                                .isim(isim)
                                .mevki(mevki)
                                .formaNo(formaNo)
                                .deger(deger).build());
            }
            connectionProvider.closeConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return futbolcuList;
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {


        return Optional.empty();
    }
}
