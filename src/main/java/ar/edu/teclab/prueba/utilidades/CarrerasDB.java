/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.edu.teclab.prueba.utilidades;

import ar.edu.teclab.prueba.entity.Carrera;
import ar.edu.teclab.prueba.entity.Facultad;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.List;

/**
 *
 * @author fcastillo
 */
public class CarrerasDB {

    private static Hashtable<Integer, Carrera> carreras;

    static {
        carreras = new Hashtable<>();
        carreras.put(1, new Carrera(1, "Programador Universitario en Informática", "3 Años", 1, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(2, new Carrera(2, "Licenciatura en Sistemas de Información", "5 Años", 2, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(3, new Carrera(3, "Profesorado en informática", "5 Años", 2, new Facultad(1, "Facultad de Ciencias Exactas y Tecnologías")));
        carreras.put(4, new Carrera(4, "Medicina", "5 Años", 2, new Facultad(2, "Facultad de Ciencias Médicas")));
    }

    public static Carrera findCarreraById(int id) {
        return carreras.get(id);
    }

    public static boolean create(Carrera carrera) {
        boolean containsKey = carreras.containsKey(carrera.getId());

        boolean created = false;

        if (!containsKey) {
            carreras.put(carrera.getId(), carrera);
            created = true;
        }
        return created;

    }

    public static boolean delete(int idCarrera) {
        boolean containsKey = carreras.containsKey(idCarrera);
        boolean deleted = false;

        if (containsKey) {
            carreras.remove(idCarrera);
            deleted = true;
        }

        return deleted;

    }

    public static List<Carrera> findAll() {
        List<Carrera> lstCarrera = new ArrayList<>();
        carreras.forEach((k, v) -> {
            lstCarrera.add(v);
        });
        return lstCarrera;
    }

    public static void edit(Carrera carrera) {
        Carrera c = carreras.get(carrera.getId());
        c.setNombre(carrera.getNombre());
    }
}
