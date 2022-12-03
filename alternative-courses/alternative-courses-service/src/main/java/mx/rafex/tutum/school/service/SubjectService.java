package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.Subject;

public interface SubjectService {

    List<Subject> findByStudent(Integer id);

}
