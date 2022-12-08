package mx.rafex.tutum.school.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.mapper.StudentMapper;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.repository.StudentRepository;
import mx.rafex.tutum.school.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentMapper mapper = StudentMapper.INSTANCE;

    @Autowired
    private StudentRepository repository;

    @Override
    public List<Student> list(Integer id) {

        List<Student> list = new ArrayList<>();

        if (id != null && id > 0) {
            Optional<StudentEntity> findById = repository.findById(id);

            if (findById.isPresent()) {
                list.add(mapper.entityToStudent(findById.get()));
            }
        }

        Iterable<StudentEntity> findAll = repository.findAll();

        findAll.forEach(s -> {
            list.add(mapper.entityToStudent(s));
        });

        return list;
    }

}
