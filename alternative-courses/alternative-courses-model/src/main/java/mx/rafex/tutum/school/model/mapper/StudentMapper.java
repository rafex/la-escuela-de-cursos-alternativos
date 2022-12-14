package mx.rafex.tutum.school.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.rest.StudentRequestRest;
import mx.rafex.tutum.school.model.vo.Student;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student entityToStudent(StudentEntity entity);

    List<Student> entityToStudent(List<StudentEntity> entity);

    EnrollSubject dtoToStudentSubject(EnrollRequestRest rest);

    @Mappings({ @Mapping(target = "id", ignore = true) })
    StudentEntity studentToEntity(Student student);

    List<StudentEntity> studentToEntity(List<Student> student);

    @Mappings({ @Mapping(target = "id", ignore = true),
            @Mapping(target = "active", ignore = true) })
    Student restToStudent(StudentRequestRest rest);

    List<Student> restToStudents(List<StudentRequestRest> rest);

    StudentRequestRest studentToRest(Student student);

    List<StudentRequestRest> studentsToRest(List<Student> student);

}
