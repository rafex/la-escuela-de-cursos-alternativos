package mx.rafex.tutum.school.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import mx.rafex.tutum.school.model.entity.EnrollSubject;

public class StudentSubjectRowMapper implements RowMapper<EnrollSubject> {

    @Override
    public EnrollSubject mapRow(ResultSet rs, int rowNum) throws SQLException {

        int idStudent = rs.getInt("id_t_usuarios");
        int idSubject = rs.getInt("id_t_materias");
        EnrollSubject enrollSubject = new EnrollSubject(idStudent, idSubject);

        return enrollSubject;
    }

}
