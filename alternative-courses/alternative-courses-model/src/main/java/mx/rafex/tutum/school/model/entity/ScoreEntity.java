package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_calificaciones")
@Data
public class ScoreEntity implements Serializable {

    private static final long serialVersionUID = 1689253546779793416L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private int id;

    @Column(name = "id_t_materias", insertable = false, updatable = false)
    private int idMaterias;

    @Column(name = "id_t_materias", insertable = false, updatable = false)
    private int idUsuarios;

    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;

    @Column(name = "calificacion")
    private float score;

}
