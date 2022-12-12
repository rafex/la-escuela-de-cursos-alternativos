package mx.rafex.tutum.school.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import mx.rafex.tutum.school.model.entity.SubjectEntity;
import mx.rafex.tutum.school.model.vo.Subject;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, nullValueMappingStrategy = NullValueMappingStrategy.RETURN_NULL)
public interface SubjectMapper {

    SubjectMapper INSTANCE = Mappers.getMapper(SubjectMapper.class);

    Subject entityToSubject(SubjectEntity entity);

}
