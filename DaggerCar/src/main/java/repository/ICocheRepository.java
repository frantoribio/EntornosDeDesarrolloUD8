package repository;

import models.Coche;

import java.util.List;

public interface ICocheRepository {
    List<Coche> findAll();

    void save(Coche coche);

    void delete(Coche coche);

    void update(Coche coche, String uuid);

}
