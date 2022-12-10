package mx.rafex.tutum.school.webapp.service;

import java.util.List;

import mx.rafex.tutum.school.model.vo.Student;

public interface StudentService {

    List<Student> list(Object keyword);

}
