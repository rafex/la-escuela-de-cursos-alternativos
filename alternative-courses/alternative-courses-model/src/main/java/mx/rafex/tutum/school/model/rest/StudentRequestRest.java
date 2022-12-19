package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

@Data
public class StudentRequestRest implements Serializable {

    private static final long serialVersionUID = 4374333629980943328L;

    @JsonProperty(value = "id", required = false)
    private int id;

    @JsonProperty(value = "nombre", required = true)
    private String name;

    @JsonProperty(value = "apellidoPaterno", required = true)
    private String lastname;

    @JsonProperty(value = "apellidoMaterno", required = true)
    private String surname;

    @JsonProperty(value = "activo", required = false)
    private boolean active;

    @JsonProperty(value = "nombreCompleto", required = false)
    @Getter(AccessLevel.NONE)
    private String fullName;

    public StudentRequestRest() {

    }

    public StudentRequestRest(int id, String name, String lastname,
            String surname, boolean active) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.active = active;
    }

    public StudentRequestRest(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName = String.format("%s %s %s", name, lastname, surname);
    }

}
