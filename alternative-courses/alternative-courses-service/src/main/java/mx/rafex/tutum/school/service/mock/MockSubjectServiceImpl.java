package mx.rafex.tutum.school.service.mock;

import java.util.LinkedList;
import java.util.List;

import mx.rafex.tutum.school.model.Subject;
import mx.rafex.tutum.school.service.SubjectService;

public class MockSubjectServiceImpl implements SubjectService {

    private List<Subject> list = new LinkedList<Subject>();
    private static int id = 1;

    public MockSubjectServiceImpl() {
        super();

        list.add(new Subject(id++, "Matematicas", 0));
        list.add(new Subject(id++, "Español", 0));
        list.add(new Subject(id++, "Geografia", 0));

    }

    @Override
    public List<Subject> findByStudent(Integer id) {
        return list;
    }

}
