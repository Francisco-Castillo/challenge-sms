package ar.edu.teclab.prueba.service;

//<editor-fold defaultstate="collapsed" desc="imports">
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.utilidades.CarrerasDB;
import java.util.List;
import org.springframework.stereotype.Service;
//</editor-fold>

/**
 *
 * @author Francisco Castillo
 */
@Service
public class CarreraService {

    //<editor-fold defaultstate="collapsed" desc="findCarreraById(int carreraId)">
    public Carrera findCarreraById(int carreraId) {
        return CarrerasDB.findCarreraById(carreraId);
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="findAll()">
    public List<Carrera> findAll() {
        return CarrerasDB.findAll();
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delete(carreraID)">
    public boolean delete(int carreraId) {
        return CarrerasDB.delete(carreraId);
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="create(Carrera carrera)">
    public boolean create(Carrera carrera) {
        return CarrerasDB.create(carrera);
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="edit(Carrera carrera)">
    public void edit(Carrera carrera) {
        CarrerasDB.edit(carrera);
    }//</editor-fold>

}
