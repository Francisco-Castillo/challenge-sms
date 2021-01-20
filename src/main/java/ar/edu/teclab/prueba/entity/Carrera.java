package ar.edu.teclab.prueba.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author fcastillo
 */
@Entity
@Table(name = "carreras")
public class Carrera {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    private String duracion;

    @Column(name = "tipo")
    private int tipo;

    @JoinColumn(name = "facultad_id", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false)
    private Facultad facultad;
}
