package mx.rafex.tutum.school.webapp.viewModel;

import java.util.logging.Logger;

import org.zkoss.zk.ui.annotation.Command;

import mx.rafex.tutum.school.service.SubjectService;
import mx.rafex.tutum.school.service.mock.MockSubjectServiceImpl;
import mx.rafex.tutum.school.webapp.form.SubjectForm;

public class MarkViewModel extends SubjectForm {

    private final static Logger LOG = Logger
            .getLogger(MarkViewModel.class.getName());

    private SubjectService service = new MockSubjectServiceImpl();

    public MarkViewModel() {
        super();
        getSubjectList().addAll(service.findByStudent(1));
    }

    @Command
    public void search() {
        getSubjectList().clear();
        getSubjectList().addAll(service.findByStudent(1));
    }

    @Command
    public void submit() {
        LOG.info(this.getSubject().toString());
        LOG.info(this.getSubjectList().toString());
    }

}
