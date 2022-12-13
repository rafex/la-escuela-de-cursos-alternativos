package mx.rafex.tutum.school.dao.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import mx.rafex.tutum.school.dao.ADao;
import mx.rafex.tutum.school.dao.StudentDao;
import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentSubjects;
import mx.rafex.tutum.school.model.mapper.StudentSubjectRowMapper;

@Component
public class StudentDaoImpl extends ADao implements StudentDao {

    @Value("${jdbc.insert.studentsubject}")
    public String insert;

    @Value("${jdbc.select.studentsubjects}")
    public String select;

    public StudentDaoImpl(final JdbcTemplate jdbc, final Environment env) {
        super(jdbc, env);
    }

    @Override
    public boolean enrollSubject(final EnrollSubject enrollSubject) {

        final var query = insert;

        try {

            jdbc.update(query, (PreparedStatementSetter) ps -> {
                ps.setInt(1, enrollSubject.getIdStudent());
                ps.setInt(2, enrollSubject.getIdSubject());
            });

        } catch (final Exception e) {
            LOG.warning(e.getMessage());
            return false;
        }

        return true;
    }

    @Override
    public StudentSubjects getSubjects(final int idStudent) {

        final var query = select;

        StudentSubjects studentSubjects = jdbc.query(query,
                (PreparedStatementSetter) ps -> {
                    ps.setInt(1, idStudent);
                },
                (ResultSetExtractor<StudentSubjects>) new StudentSubjectRowMapper());

        return studentSubjects;
    }

}
