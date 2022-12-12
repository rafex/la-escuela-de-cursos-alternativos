package mx.rafex.tutum.school.dao;

import java.util.logging.Logger;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;

public abstract class ADao {

    protected static final Logger LOG = Logger.getLogger(ADao.class.getName());

    protected final JdbcTemplate jdbc;
    protected final Environment env;

    public ADao(final JdbcTemplate jdbc, final Environment env) {
        this.jdbc = jdbc;
        this.env = env;
    }
}
