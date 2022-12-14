package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SubjectRest implements Serializable {

    private static final long serialVersionUID = -6664347524855261529L;

    @JsonProperty(value = "id", required = true)
    private int id;

    @JsonProperty(value = "nombre", required = false)
    private String name;

    @JsonProperty(value = "calificacion", required = true)
    private double score;

}
