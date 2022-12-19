package mx.rafex.tutum.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.rafex.tutum.school.model.entity.SubjectEntity;

@Repository
public interface SubjectRepository
        extends CrudRepository<SubjectEntity, Integer> {

}
