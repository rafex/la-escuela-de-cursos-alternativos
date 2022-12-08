package mx.rafex.tutum.school.webapp.tmp;

import java.util.LinkedList;
import java.util.List;

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
