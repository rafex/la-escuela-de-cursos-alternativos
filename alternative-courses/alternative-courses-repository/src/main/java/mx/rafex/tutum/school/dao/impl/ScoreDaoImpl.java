package mx.rafex.tutum.school.dao.impl;

import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Service;

import mx.rafex.tutum.school.dao.ADao;
import mx.rafex.tutum.school.dao.ScoreDao;
import mx.rafex.tutum.school.model.entity.Score;

@Service
public class ScoreDaoImpl extends ADao implements ScoreDao {

    @Value("${jdbc.insert.score}")
    public String insert;

    public ScoreDaoImpl(JdbcTemplate jdbc, Environment env) {
        super(jdbc, env);
    }

    @Override
    public boolean save(Score score) {
        final var query = insert;

        try {

            jdbc.update(query, (PreparedStatementSetter) ps -> {
                ps.setInt(1, score.getSubject());
                ps.setInt(2, score.getStudent());
                ps.setDouble(3, score.getScore());
                ps.setTimestamp(4,
                        Timestamp.valueOf(score.getRegistrationDate()));
            });

        } catch (final Exception e) {
            LOG.warning(e.getMessage());
            return false;
        }

        return true;
    }

}
