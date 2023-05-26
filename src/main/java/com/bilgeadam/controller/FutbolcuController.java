package com.bilgeadam.controller;

import com.bilgeadam.repository.ICrud;
import com.bilgeadam.repository.entity.Futbolcu;
import com.bilgeadam.service.FutbolcuService;
import com.bilgeadam.utility.ConnectionProvider;

import java.util.List;
import java.util.Optional;

public class FutbolcuController implements ICrud<Futbolcu> {

    FutbolcuService futbolcuService;

    public FutbolcuController(ConnectionProvider connectionProvider) {
        this.futbolcuService = new FutbolcuService(connectionProvider);
    }

    @Override
    public void save(Futbolcu futbolcu) {
        futbolcuService.save(futbolcu);
    }

    @Override
    public void update(Futbolcu futbolcu) {
        futbolcuService.update(futbolcu);
    }

    @Override
    public void delete(Long id) {
        futbolcuService.delete(id);
    }

    @Override
    public List<Futbolcu> findAll() {
        return futbolcuService.findAll();
    }

    @Override
    public Optional<Futbolcu> findById(Long id) {
        return futbolcuService.findById(id);
    }
}
