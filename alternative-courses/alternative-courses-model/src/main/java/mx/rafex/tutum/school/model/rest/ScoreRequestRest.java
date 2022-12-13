package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ScoreRequestRest implements Serializable {

    private static final long serialVersionUID = 9108823114608540608L;

    @JsonProperty(value = "calificacion", required = true)
    private double score;

}
