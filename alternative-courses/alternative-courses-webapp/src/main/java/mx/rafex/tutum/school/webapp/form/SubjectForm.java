package mx.rafex.tutum.school.webapp.form;

import java.util.List;

import org.zkoss.zul.ListModelList;

import mx.rafex.tutum.school.model.Subject;

public class SubjectForm {

    private List<Subject> subjectList = new ListModelList<Subject>();
    private Subject subject;

    public SubjectForm() {
        super();
        subject = new Subject();
    }

    public SubjectForm(final Subject subject) {
        super();
        this.subject = subject;
    }

    /**
     * @return the subject
     */
    public Subject getSubject() {
        return subject;
    }

    /**
     * @param subject the subject to set
     */
    public void setSubject(final Subject subject) {
        this.subject = subject;
    }

    /**
     * @return the subjectList
     */
    public List<Subject> getSubjectList() {
        return subjectList;
    }

    /**
     * @param subjectList the subjectList to set
     */
    public void setSubjectList(List<Subject> subjectList) {
        this.subjectList = subjectList;
    }

}
