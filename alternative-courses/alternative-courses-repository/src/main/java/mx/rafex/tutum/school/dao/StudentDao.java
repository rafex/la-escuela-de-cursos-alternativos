package mx.rafex.tutum.school.dao;

import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentSubjects;

public interface StudentDao {

    boolean enrollSubject(EnrollSubject enrollSubject);

    StudentSubjects getSubjects(int idStudent);

}
