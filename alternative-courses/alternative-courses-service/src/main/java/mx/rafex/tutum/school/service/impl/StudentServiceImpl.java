package mx.rafex.tutum.school.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

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
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Service
public class StudentServiceImpl implements StudentService {

    private final static Logger LOG = Logger
            .getLogger(StudentServiceImpl.class.getName());

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

    @Override
    public JasperPrint report(int idStudent) {

//        List<Subject> subjectList = new ArrayList<>();
//
//        subjectList.add(new Subject("Ingles", 9.4));
//        subjectList.add(new Subject("Geografia", 9.4));

        StudentSubjects studentSubjects = getSubjects(idStudent);

        if (studentSubjects != null && studentSubjects.getSubjects() != null
                && !studentSubjects.getSubjects().isEmpty()) {

            List<Subject> subjectList = studentSubjects.getSubjects();

            try {

                // dynamic parameters required for report
                Map<String, Object> empParams = new HashMap<String, Object>();
                empParams.put("CompanyName", "Tecnologico patito de SA de CV");
                empParams.put("scoreData",
                        new JRBeanCollectionDataSource(subjectList));

                JasperPrint empReport = JasperFillManager.fillReport(
                        JasperCompileManager.compileReport(ResourceUtils
                                .getFile("classpath:score-list.jrxml")
                                .getAbsolutePath()) // path of the jasper
                                                    // report
                        , empParams // dynamic parameters
                        , new JREmptyDataSource());

                return empReport;
            } catch (Exception e) {
                LOG.info(e.getMessage());
            }

        }

        throw new RuntimeException("Fallo crear el reporte");
    }

}
