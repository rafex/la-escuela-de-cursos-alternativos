package mx.rafex.tutum.school.service;

import java.util.List;

import mx.rafex.tutum.school.model.mapper.SubjectMapper;
import mx.rafex.tutum.school.model.vo.Subject;

public interface SubjectService {

    SubjectMapper SUBJECT_MAPPER = SubjectMapper.INSTANCE;

    List<Subject> list(Integer id);

}
