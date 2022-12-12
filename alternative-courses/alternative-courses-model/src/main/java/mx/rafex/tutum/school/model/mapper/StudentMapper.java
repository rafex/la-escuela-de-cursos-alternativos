package mx.rafex.tutum.school.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import mx.rafex.tutum.school.model.entity.EnrollSubject;
import mx.rafex.tutum.school.model.entity.StudentEntity;
import mx.rafex.tutum.school.model.rest.EnrollRequestRest;
import mx.rafex.tutum.school.model.vo.Student;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface StudentMapper {

    StudentMapper INSTANCE = Mappers.getMapper(StudentMapper.class);

    Student entityToStudent(StudentEntity entity);

    EnrollSubject dtoToStudentSubject(EnrollRequestRest enrollRequestRest);

}
