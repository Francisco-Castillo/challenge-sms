package ar.edu.teclab.prueba.controller;

//<editor-fold defaultstate="collapsed" desc="imports">
import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.service.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//</editor-fold>

/**
 *
 * @author Francisco Castillo
 */
@RestController
@RequestMapping("/carrera")
@CrossOrigin(origins = "*")
public class CarreraController {
    
    //<editor-fold defaultstate="collapsed" desc="fields">
    @Autowired
    CarreraService carreraService;
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="findAll()">
    @GetMapping
    public ResponseEntity findAll() {
        return ResponseEntity.ok(carreraService.findAll());
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="findCarreraById(int carrera_id)">
    @GetMapping("{carrera_id}")
    public ResponseEntity findCarreraById(@PathVariable int carrera_id) {
        Carrera carrera = carreraService.findCarreraById(carrera_id);
        return ResponseEntity.ok(carrera);
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="delete(int carrera_id)">
    @DeleteMapping("{carrera_id}")
    public ResponseEntity delete(@PathVariable int carrera_id) {
        boolean delete = carreraService.delete(carrera_id);

        if (delete) {
            return new ResponseEntity("Carrera removida exitosamente", HttpStatus.OK);
        } else {
            return new ResponseEntity("No se encontro la carrera con id: " + carrera_id, HttpStatus.BAD_REQUEST);
        }
    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="create(Carrera carrera)">
    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity create(@RequestBody Carrera carrera) {
        boolean created = carreraService.create(carrera);
        if (created) {
            return new ResponseEntity("Carrera registrada exitosamente", HttpStatus.CREATED);
        } else {
            return new ResponseEntity("La carrera de " + carrera.getNombre() + ", ya se encuentra registrada", HttpStatus.CONFLICT);
        }

    }//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="edit(Carrera carrera)">
    @PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity edit(@RequestBody Carrera carrera) {
        carreraService.create(carrera);
        return new ResponseEntity("Carrera editada exitosamente", HttpStatus.OK);
    }//</editor-fold>

}
