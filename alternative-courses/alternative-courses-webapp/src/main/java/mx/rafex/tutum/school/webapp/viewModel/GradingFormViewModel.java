package mx.rafex.tutum.school.webapp.viewModel;

import java.util.Map;
import java.util.logging.Logger;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import mx.rafex.tutum.school.webapp.form.SubjectForm;
import mx.rafex.tutum.school.webapp.service.StudentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class GradingFormViewModel extends SubjectForm {

    private final static Logger LOG = Logger
            .getLogger(GradingFormViewModel.class.getName());

    @WireVariable("studentServiceImpl")
    private StudentService service;

//    private SubjectService service = new MockSubjectServiceImpl();

    @Init
    public void init() {

        Map<String, String[]> parameterMap = Executions.getCurrent()
                .getParameterMap();

        parameterMap.forEach((k, v) -> {

            LOG.info(String.format("Parametro [ %s = %s ]", k, v.toString()));
        });

        String arg = Executions.getCurrent().getParameter("arg1");
        LOG.info(String.format("Argumento [arg1] = %s", arg));

        setIdStudent(Integer.valueOf(arg));

        getSubjectList().addAll(service.getSubjects(getIdStudent()));
    }

    public GradingFormViewModel() {
        super();

    }

    @Command
    public void submit() {
        LOG.info(this.getSubject().toString());
        LOG.info(this.getSubjectList().toString());

        service.saveScore(getIdStudent(), getSubject().getId(),
                getSubject().getScore());

    }

}
