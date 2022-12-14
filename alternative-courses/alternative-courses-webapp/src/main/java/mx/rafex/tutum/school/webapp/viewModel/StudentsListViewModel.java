package mx.rafex.tutum.school.webapp.viewModel;

import java.util.List;
import java.util.logging.Logger;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.webapp.form.SubjectForm;
import mx.rafex.tutum.school.webapp.service.StudentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class StudentsListViewModel extends SubjectForm {

    private final static Logger LOG = Logger
            .getLogger(StudentsListViewModel.class.getName());

    private String keyword;
    private List<Student> list = new ListModelList<>();
    private Student selected;

    @WireVariable("studentServiceImpl")
    private StudentService service;

    @Init
    public void init() {
        list.clear();
        list.addAll(service.list(keyword));
    }

    @Command
    public void search() {
        list.clear();
        list.addAll(service.list(keyword));
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getKeyword() {
        return keyword;
    }

    /**
     * @return the list
     */
    public List<Student> getList() {
        return list;
    }

    /**
     * @return the selected
     */
    public Student getSelected() {
        return selected;
    }

    /**
     * @param selected the selected to set
     */
    public void setSelected(Student selected) {
        this.selected = selected;
    }

    @Command
    public void getForm(@BindingParam("id") final String id) {
        LOG.info("Redirec!!!");
        // create a window programmatically and use it as a modal dialog.
        // Executions.sendRedirect("~./zul/form.zul?arg1=hola");
        Executions.sendRedirect(String.format("form?arg1=%s", id));
//        Window window = (Window) Executions
//                .createComponents("~./zul/window_dialog.zul", null, null);
//        window.doModal();
    }

}
