package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "t_alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentEntity implements Serializable {

    private static final long serialVersionUID = -1984898904812100754L;

    @Id
    @SequenceGenerator(name = "mytable_id_seq", sequenceName = "s_alumno", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mytable_id_seq")
    @Column(name = "id_t_usuarios")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "ap_paterno")
    private String lastname;

    @Column(name = "ap_materno")
    private String surname;

    @Column(name = "activo")
    private boolean active;

}
