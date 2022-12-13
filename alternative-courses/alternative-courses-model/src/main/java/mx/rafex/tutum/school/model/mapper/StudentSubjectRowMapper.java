package mx.rafex.tutum.school.model.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.entity.StudentSubjects;
import mx.rafex.tutum.school.model.entity.SubjectEntity;

public class StudentSubjectRowMapper implements RowMapper<EnrollSubject>,
        ResultSetExtractor<StudentSubjects> {

    @Override
    public EnrollSubject mapRow(ResultSet rs, int rowNum) throws SQLException {

        int idStudent = rs.getInt("id_t_usuarios");
        int idSubject = rs.getInt("id_t_materias");
        EnrollSubject enrollSubject = new EnrollSubject(idStudent, idSubject);

        return enrollSubject;
    }

    @Override
    public StudentSubjects extractData(ResultSet rs)
            throws SQLException, DataAccessException {

        final StudentSubjects studentSubjects = new StudentSubjects();

        final List<SubjectEntity> subjects = new ArrayList<SubjectEntity>();

        while (rs.next()) {

            if (studentSubjects.getStudent() == null) {
                StudentEntity student = new StudentEntity(rs.getInt("id"),
                        rs.getString("nombre"), rs.getString("paterno"),
                        rs.getString("materno"), rs.getBoolean("activo"));

                studentSubjects.setStudent(student);
            }

            subjects.add(new SubjectEntity(rs.getInt("idmateria"),
                    rs.getString("materia"), rs.getBoolean("mactivo")));

        }

        studentSubjects.setSubjects(subjects);

        return studentSubjects;
    }

}
