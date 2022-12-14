package mx.rafex.tutum.school.dao;

import java.util.List;

import mx.rafex.tutum.school.model.entity.Score;

public interface ScoreDao {

    boolean save(Score score);

    boolean save(List<Score> scores);

}
