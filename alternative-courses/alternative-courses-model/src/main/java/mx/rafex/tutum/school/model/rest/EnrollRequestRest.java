package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class EnrollRequestRest implements Serializable {

    private static final long serialVersionUID = -3825514580544975440L;

    @JsonProperty("idUsuario")
    private int idStudent;
    @JsonProperty("idMateria")
    private int idSubject;

}
