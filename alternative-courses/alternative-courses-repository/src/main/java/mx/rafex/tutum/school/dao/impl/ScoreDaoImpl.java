package mx.rafex.tutum.school.dao.impl;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.dao.DuplicateKeyException;
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

    @Value("${jdbc.insert.scores}")
    public String inserts;

    @Value("${jdbc.update.score}")
    public String update;

    public ScoreDaoImpl(final JdbcTemplate jdbc, final Environment env) {
        super(jdbc, env);
    }

    @Override
    public boolean save(final Score score) {
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

    @Override
    public boolean save(final List<Score> scores) {

        final var insert = this.insert;
        final var update = this.update;

        try {
            scores.forEach(score -> {
                try {

                    jdbc.update(insert, (PreparedStatementSetter) ps -> {

                        final var index = new AtomicInteger(0);

                        final var _1 = index.incrementAndGet();
                        final var _2 = index.incrementAndGet();
                        final var _3 = index.incrementAndGet();
                        final var _4 = index.incrementAndGet();

                        try {
                            ps.setInt(_1, score.getSubject());
                            ps.setInt(_2, score.getStudent());
                            ps.setDouble(_3, score.getScore());
                            ps.setTimestamp(_4, Timestamp
                                    .valueOf(score.getRegistrationDate()));
                        } catch (final SQLException e) {
                            LOG.warning(e.getMessage());
                        }

                    });

                } catch (final Exception e) {

                    if (e instanceof DuplicateKeyException) {

                        jdbc.update(update, (PreparedStatementSetter) ps -> {

                            final var index = new AtomicInteger(0);

                            final var _1 = index.incrementAndGet();
                            final var _2 = index.incrementAndGet();
                            final var _3 = index.incrementAndGet();

                            try {
                                ps.setDouble(_1, score.getScore());
                                ps.setInt(_2, score.getSubject());
                                ps.setInt(_3, score.getStudent());
                            } catch (final SQLException e2) {
                                LOG.warning(e.getMessage());
                            }
                        });

                    } else {
                        LOG.warning(e.getMessage());
                    }

                }

            });
        } catch (final Exception e) {
            return false;
        }

        return true;
    }

}
