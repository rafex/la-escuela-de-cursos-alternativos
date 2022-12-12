package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EnrollSubject implements Serializable {

    private static final long serialVersionUID = -8485034835727407022L;

    private int idStudent;
    private int idSubject;

}
