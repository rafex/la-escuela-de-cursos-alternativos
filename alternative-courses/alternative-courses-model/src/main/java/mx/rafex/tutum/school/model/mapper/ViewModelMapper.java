package mx.rafex.tutum.school.model.mapper;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import mx.rafex.tutum.school.model.rest.StudentRequestRest;
import mx.rafex.tutum.school.model.vo.Student;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface ViewModelMapper {

    ViewModelMapper INSTANCE = Mappers.getMapper(ViewModelMapper.class);

    Student restToStudent(StudentRequestRest rest);

    List<Student> restToStudents(List<StudentRequestRest> rest);

}
