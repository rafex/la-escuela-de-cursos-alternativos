package mx.rafex.tutum.school.dao;

import java.util.List;

import mx.rafex.tutum.school.model.entity.EnrollSubject;

public interface StudentDao {

    List<EnrollSubject> enrollSubject(EnrollSubject enrollSubject);

}
