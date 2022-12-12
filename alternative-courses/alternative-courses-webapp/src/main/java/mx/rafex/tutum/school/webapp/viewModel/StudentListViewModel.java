package mx.rafex.tutum.school.webapp.viewModel;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.zkoss.bind.annotation.BindingParam;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.annotation.Command;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.ListModelList;

import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.webapp.service.StudentService;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class StudentListViewModel {

    private final static Logger LOG = Logger
            .getLogger(StudentListViewModel.class.getName());

    private String keyword;
    private List<Student> list = new ListModelList<>();
    private Student selected;

    @WireVariable("studentServiceImpl")
    private StudentService service;

    Map<String, PageModel<String>> pages = new HashMap<>();
    private PageModel<String> currentPage;

    @Init
    public void init() {
        pages.put("page1", new PageModel<>("~./zul/mvvm-page1.zul",
                "some data for page 1 (could be a more complex object)"));
        pages.put("page2", new PageModel<>("~./zul/mvvm-page2.zul",
                "different data for page 2"));
    }

    @Command
    public void search() {
        list.clear();
//        list.addAll(service.search(keyword));
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
    @NotifyChange("currentPage")
    public void navigate(@BindingParam("page") String page) {
        this.currentPage = pages.get(page);
    }

    public PageModel getCurrentPage() {
        return currentPage;
    }

    @Command
    public void getForm(@BindingParam("id") final String id) {
        LOG.info("Redirec!!!");
        // create a window programmatically and use it as a modal dialog.
        // Executions.sendRedirect("~./zul/form.zul?arg1=hola");
        Executions.sendRedirect("form?arg1=" + id + "&arg2=dos");
//        Window window = (Window) Executions
//                .createComponents("~./zul/window_dialog.zul", null, null);
//        window.doModal();
    }

}
