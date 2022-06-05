package controllers;

import models.Coche;
import repository.ICocheRepository;

import javax.inject.Inject;
import java.util.List;

public class CocheController {
    ICocheRepository cochesRepository;

    @Inject
    CocheController(ICocheRepository coches) {
        this.cochesRepository = coches;
    }

    public List<Coche> getAll() {
        return cochesRepository.findAll();
    }

    public void saveCoche(Coche coche) {
        cochesRepository.save(coche);
    }

    public void deleteCoche(Coche coche) {
        cochesRepository.delete(coche);
    }

}


