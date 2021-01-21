package ar.edu.teclab.prueba.service;

import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.utilidades.CarrerasDB;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author fcastillo
 */
@Service
public class CarreraService {

    public Carrera findCarreraById(int carreraId) {
        return CarrerasDB.findCarreraById(carreraId);
    }

    public List<Carrera> findAll() {
        return CarrerasDB.findAll();
    }

    public boolean delete(int carreraId) {
        return CarrerasDB.delete(carreraId);
    }

    public boolean create(Carrera carrera) {
        return CarrerasDB.create(carrera);
    }

    public void edit(Carrera carrera) {
        CarrerasDB.edit(carrera);
    }

}
