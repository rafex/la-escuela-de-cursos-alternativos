package mx.rafex.tutum.school.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.vo.Subject;
import mx.rafex.tutum.school.repository.SubjectRepository;
import mx.rafex.tutum.school.service.SubjectService;

@Service
public class SubjectServiceImpl implements SubjectService {

    private final SubjectMapper mapper = SubjectMapper.INSTANCE;

    @Autowired
    private SubjectRepository repository;

    @Override
    public List<Subject> list(final Integer id) {

        final List<Subject> list = new ArrayList<>();

        if (id != null && id > 0) {
            final var findById = repository.findById(id);

            if (findById.isPresent()) {
                list.add(mapper.entityToSubject(findById.get()));
            }
        }

        final var findAll = repository.findAll();

        findAll.forEach(s -> {
            list.add(mapper.entityToSubject(s));
        });

        return list;

    }

}
