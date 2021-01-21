package ar.edu.teclab.prueba.utilidades;

//<editor-fold defaultstate="collapsed" desc="imports">
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.entity.Facultad;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
//</editor-fold>

/**
 * Esta clase emula un acceso a una base de datos. A través de esta clase
 * podemos, se puede acceder y manipular información de carreras
 *
 * @author Francisco Castillo
 */
public class CarrerasDB {

    //<editor-fold defaultstate="collapsed" desc="fields">
    private static final HashMap<Integer, Carrera> carreras;

    static {
        carreras = new HashMap<>();
        carreras.put(1, new Carrera(1, "Programador Universitario en Informática", "3 Años", 1, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(2, new Carrera(2, "Licenciatura en Sistemas de Información", "5 Años", 2, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(3, new Carrera(3, "Profesorado en informática", "5 Años", 2, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(4, new Carrera(4, "Medicina", "5 Años", 2, new Facultad(2, "Facultad de Ciencias Médicas")));
    }
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="findCarreraById(int id)">
    public static Carrera findCarreraById(int id) {
        return carreras.get(id);
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="create(Carrera carrera)">
    public static boolean create(Carrera carrera) {
        boolean containsKey = carreras.containsKey(carrera.getId());

        boolean created = false;

        if (!containsKey) {
            carreras.put(carrera.getId(), carrera);
            created = true;
        }
        return created;

    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delete(int idCarrera)">
    public static boolean delete(int idCarrera) {
        boolean containsKey = carreras.containsKey(idCarrera);
        boolean deleted = false;

        if (containsKey) {
            carreras.remove(idCarrera);
            deleted = true;
        }

        return deleted;

    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="findAll()">
    public static List<Carrera> findAll() {
        List<Carrera> lstCarrera = new ArrayList<>();
        carreras.forEach((k, v) -> {
            lstCarrera.add(v);
        });
        return lstCarrera;
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="edit(Carrera carrera)">
    public static void edit(Carrera carrera) {
        Carrera c = carreras.get(carrera.getId());
        c.setNombre(carrera.getNombre());
    }//</editor-fold>
}
