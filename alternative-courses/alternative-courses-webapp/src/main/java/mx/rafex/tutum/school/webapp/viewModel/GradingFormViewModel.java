package mx.rafex.tutum.school.webapp.viewModel;

import java.util.Map;
import java.util.logging.Logger;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.annotation.Command;

import mx.rafex.tutum.school.webapp.form.SubjectForm;
import mx.rafex.tutum.school.webapp.tmp.MockSubjectServiceImpl;
import mx.rafex.tutum.school.webapp.tmp.SubjectService;

public class GradingFormViewModel extends SubjectForm {

    private final static Logger LOG = Logger
            .getLogger(GradingFormViewModel.class.getName());

    private SubjectService service = new MockSubjectServiceImpl();

    @Init
    public void init() {

        Map<String, String[]> parameterMap = Executions.getCurrent()
                .getParameterMap();

        parameterMap.forEach((k, v) -> {

            LOG.info(String.format("Parametro [ %s = %s ]", k, v.toString()));
        });

        String arg = Executions.getCurrent().getParameter("arg1");
        LOG.info(String.format("Argumento [arg1] = %s", arg));
    }

    public GradingFormViewModel() {
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