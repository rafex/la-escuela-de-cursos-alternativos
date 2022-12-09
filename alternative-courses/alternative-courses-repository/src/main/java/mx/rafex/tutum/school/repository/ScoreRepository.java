package mx.rafex.tutum.school.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import mx.rafex.tutum.school.model.entity.ScoreEntity;

@Repository
public interface ScoreRepository extends CrudRepository<ScoreEntity, Integer> {

}
