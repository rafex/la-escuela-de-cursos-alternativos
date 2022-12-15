package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Data
public class StudentsRequestRest implements Serializable {

    private static final long serialVersionUID = 6602080443327434145L;

    @JsonProperty(value = "usuarios", required = true)
    private List<StudentRequestRest> students;
}
