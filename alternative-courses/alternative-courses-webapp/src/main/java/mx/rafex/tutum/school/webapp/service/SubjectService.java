package mx.rafex.tutum.school.webapp.service;

import java.util.List;

import mx.rafex.tutum.school.model.vo.Subject;

public interface SubjectService {

    List<Subject> list(int idStudent);

}
