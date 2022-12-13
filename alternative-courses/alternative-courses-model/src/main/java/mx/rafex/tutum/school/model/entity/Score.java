package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Score implements Serializable {

    private static final long serialVersionUID = 1689253546779793416L;

    public Score() {
        registrationDate = LocalDateTime.now();
    }

    private Integer id;

    private int subject;

    private int student;

    private LocalDateTime registrationDate;

    private double score;

}
