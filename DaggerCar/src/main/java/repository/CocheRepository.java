package repository;

import models.Coche;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

public class CocheRepository implements ICocheRepository {
    private final List<Coche> coches = new ArrayList<>();

    @Inject
    CocheRepository() {
    }

    @Override
    public List<Coche> findAll() {
        return coches;
    }

    @Override
    public void save(Coche coche) {
        coches.add(coche);
    }

    @Override
    public void delete(Coche coche) {
        coches.remove(coche);

    }

    @Override
    public void update(Coche coche, String uuid) {
        coches.set(Integer.parseInt(uuid), coche);
    }
}
