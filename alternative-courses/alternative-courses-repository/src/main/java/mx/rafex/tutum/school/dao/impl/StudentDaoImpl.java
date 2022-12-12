package mx.rafex.tutum.school.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;

import mx.rafex.tutum.school.dao.ADao;
import mx.rafex.tutum.school.dao.StudentDao;
import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.mapper.StudentSubjectRowMapper;

@Component
public class StudentDaoImpl extends ADao implements StudentDao {

    @Value("${jdbc.insert.studentsubject}")
    public String insert;

    public StudentDaoImpl(JdbcTemplate jdbc, Environment env) {
        super(jdbc, env);
    }

    @Override
    public List<EnrollSubject> enrollSubject(
            final EnrollSubject enrollSubject) {

        final var query = insert;

        jdbc.query(query, (PreparedStatementSetter) ps -> {
            ps.setInt(1, enrollSubject.getIdStudent());
            ps.setInt(2, enrollSubject.getIdSubject());
        }, new StudentSubjectRowMapper());

        return null;
    }

}
