package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.mapper.StudentMapper;
import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.StudentSubjects;

public interface StudentService {

    StudentMapper STUDENT_MAPPER = StudentMapper.INSTANCE;
    SubjectMapper SUBJECT_MAPPER = SubjectMapper.INSTANCE;

    List<Student> list(int id);

    boolean enrollSubject(int idStudent, int idSubject);

    StudentSubjects getSubjects(int idStudent);

    boolean saveScore(StudentSubjects studentSubjects);

}
