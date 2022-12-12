package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "t_materias")
@Data
public class SubjectEntity implements Serializable {

    private static final long serialVersionUID = 6408350402776327939L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_t_materias")
    private int id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "activo")
    private boolean active;
}
