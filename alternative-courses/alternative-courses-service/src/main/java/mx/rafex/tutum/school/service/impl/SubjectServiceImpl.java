package mx.rafex.tutum.school.service.impl;

import java.util.LinkedList;
import java.util.List;

import mx.rafex.tutum.school.model.Subject;
import mx.rafex.tutum.school.service.SubjectService;

public class SubjectServiceImpl implements SubjectService {

    private List<Subject> list = new LinkedList<Subject>();

    public SubjectServiceImpl() {
        super();

    }

    @Override
    public List<Subject> findByStudent(Integer id) {
        return list;
    }

}
