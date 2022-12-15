package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.Transient;

import lombok.Data;

@Entity
@Table(name = "t_materias")
@Data
public class SubjectEntity implements Serializable {

    private static final long serialVersionUID = 6408350402776327939L;

    @Id
    @SequenceGenerator(name = "mytable_id_seq_2", sequenceName = "s_materia", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mytable_id_seq_2")
    @Column(name = "id_t_materias")
    private Integer id;

    @Column(name = "nombre")
    private String name;

    @Column(name = "activo")
    private boolean active;

    @Transient
    private double score;

    public SubjectEntity() {
        super();
    }

    public SubjectEntity(final Integer id, final String name,
            final boolean active) {
        super();
        this.id = id;
        this.name = name;
        this.active = active;
    }

    public SubjectEntity(final Integer id, final String name,
            final boolean active, final double score) {
        super();
        this.id = id;
        this.name = name;
        this.active = active;
        this.score = score;
    }

}
