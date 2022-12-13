package mx.rafex.tutum.school.model.entity;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjects implements Serializable {

    private static final long serialVersionUID = -8408151943686934852L;

    private StudentEntity student;

    private List<SubjectEntity> subjects;
}
