package mx.rafex.tutum.school.model.vo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentSubjects implements Serializable {

    private static final long serialVersionUID = -5020924578448032785L;

    private Student student;

    private List<Subject> subjects;
}
