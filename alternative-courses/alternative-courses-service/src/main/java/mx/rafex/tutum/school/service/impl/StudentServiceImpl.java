package mx.rafex.tutum.school.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.tutum.school.dao.StudentDao;
import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.mapper.StudentMapper;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.repository.StudentRepository;
import mx.rafex.tutum.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper MAPPER = StudentMapper.INSTANCE;

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private StudentDao studentDao;

    @Override
    public List<Student> list(int id) {

        List<Student> list = new ArrayList<>();

        if (id > 0) {
            Optional<StudentEntity> findById = studentRepository.findById(id);

            if (findById.isPresent()) {
                list.add(MAPPER.entityToStudent(findById.get()));
            }
        }

        Iterable<StudentEntity> findAll = studentRepository.findAll();

        findAll.forEach(s -> {
            list.add(MAPPER.entityToStudent(s));
        });

        return list;
    }

    @Override
    public boolean enrollSubject(int idStudent, int idSubject) {

        List<EnrollSubject> list = studentDao
                .enrollSubject(new EnrollSubject(idStudent, idSubject));

        return false;
    }

}
