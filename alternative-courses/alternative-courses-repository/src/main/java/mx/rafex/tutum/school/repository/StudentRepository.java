package mx.rafex.tutum.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.rafex.tutum.school.model.entity.StudentEntity;

@Repository
public interface StudentRepository
        extends CrudRepository<StudentEntity, Integer> {

}
