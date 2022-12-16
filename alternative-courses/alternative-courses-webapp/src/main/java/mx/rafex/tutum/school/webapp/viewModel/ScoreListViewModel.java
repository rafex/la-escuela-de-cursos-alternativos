package mx.rafex.tutum.school.webapp.viewModel;

import java.util.logging.Logger;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import mx.rafex.tutum.school.webapp.form.SubjectForm;
import mx.rafex.tutum.school.webapp.service.StudentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class ScoreListViewModel extends SubjectForm {

    private final static Logger LOG = Logger
            .getLogger(ScoreListViewModel.class.getName());

    @WireVariable("studentServiceImpl")
    private StudentService service;

    @Init
    public void init() {

        final var parameterMap = Executions.getCurrent().getParameterMap();

        parameterMap.forEach((k, v) -> {

            LOG.info(String.format("Parametro [ %s = %s ]", k, v.toString()));
        });

        final var arg = Executions.getCurrent().getParameter("arg1");
        LOG.info(String.format("Argumento [arg1] = %s", arg));

        var idStudent = Integer.valueOf(arg);

        setIdStudent(idStudent);

        getSubjectList().addAll(service.getSubjects(getIdStudent()));

        setUrl(service.report(getIdStudent()));
    }

    public ScoreListViewModel() {
        super();

    }

    @Command
    public void submit() {
        LOG.info(getSubject().toString());
        LOG.info(getSubjectList().toString());

        service.saveScore(getIdStudent(), getSubjectList());

    }

}
