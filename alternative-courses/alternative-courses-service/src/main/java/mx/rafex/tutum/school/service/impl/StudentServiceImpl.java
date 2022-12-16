package mx.rafex.tutum.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.tutum.school.dao.ScoreDao;
import mx.rafex.tutum.school.dao.StudentDao;
import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.Score;
import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.StudentSubjects;
import mx.rafex.tutum.school.model.vo.Subject;
import mx.rafex.tutum.school.repository.StudentRepository;
import mx.rafex.tutum.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDao studentDao;

    @Autowired
    private ScoreDao scoreDao;

    @Override
    public List<Student> list(final int id) {

        final List<Student> list = new ArrayList<>();

        if (id > 0) {
            final var findById = studentRepository.findById(id);

            if (findById.isPresent()) {
                list.add(STUDENT_MAPPER.entityToStudent(findById.get()));
            }
        }

        final var findAll = studentRepository.findAll();

        findAll.forEach(s -> {
            list.add(STUDENT_MAPPER.entityToStudent(s));
        });

        return list;
    }

    @Override
    public boolean enrollSubject(final int idStudent, final int idSubject) {

        if (studentDao.enrollSubject(new EnrollSubject(idStudent, idSubject))) {

            scoreDao.save(new Score(idStudent, idSubject));

            return true;
        }

        return false;
    }

    @Override
    public mx.rafex.tutum.school.model.vo.StudentSubjects getSubjects(
            final int idStudent) {

        final var subjects = studentDao.getSubjects(idStudent);

        final var studentSubjects = new mx.rafex.tutum.school.model.vo.StudentSubjects();

        studentSubjects.setStudent(
                STUDENT_MAPPER.entityToStudent(subjects.getStudent()));

        final List<Subject> listSubject = new ArrayList<>();

        subjects.getSubjects().forEach(entity -> {
            listSubject.add(SUBJECT_MAPPER.entityToSubject(entity));
        });

        studentSubjects.setSubjects(listSubject);

        return studentSubjects;
    }

    @Override
    public boolean saveScore(final StudentSubjects studentSubjects) {

        if (studentSubjects != null && studentSubjects.getStudent() != null
                && studentSubjects.getStudent().getId() > 0
                && studentSubjects.getSubjects() != null
                && !studentSubjects.getSubjects().isEmpty()) {
            List<Score> scores = new ArrayList<>();

            studentSubjects.getSubjects().forEach(subject -> {
                final var score = new Score();
                score.setStudent(studentSubjects.getStudent().getId());
                score.setSubject(subject.getId());
                score.setScore(subject.getScore());
                scores.add(score);
            });

            return scoreDao.save(scores);
        }

        return false;
    }

    @Override
    public List<Student> save(List<Student> students) {

        List<StudentEntity> studentsEntity = STUDENT_MAPPER
                .studentToEntity(students);

        Iterable<StudentEntity> saveAll = studentRepository
                .saveAll(studentsEntity);

        List<Student> list = new ArrayList<>();

        saveAll.forEach(entity -> {
            list.add(STUDENT_MAPPER.entityToStudent(entity));
        });

        return list;
    }

}
