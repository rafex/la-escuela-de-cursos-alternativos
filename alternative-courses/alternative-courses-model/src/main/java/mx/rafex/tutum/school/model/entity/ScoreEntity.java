package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "t_calificaciones")
@Data
@AllArgsConstructor
public class ScoreEntity implements Serializable {

    private static final long serialVersionUID = 1689253546779793416L;

    public ScoreEntity() {
        registrationDate = LocalDateTime.now();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_calificaciones")
    private int id;

    @Column(name = "id_t_materias", insertable = false, updatable = false)
    private int subject;

    @Column(name = "id_t_materias", insertable = false, updatable = false)
    private int student;

    @Column(name = "fecha_registro")
    private LocalDateTime registrationDate;

    @Column(name = "calificacion")
    private double score;

}
