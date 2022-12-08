package mx.rafex.tutum.school.model.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 8743813932176062131L;

    private int id;

    private String name;

    private String lastname;

    private String surname;

    private boolean active;

    public String fullName() {
        return String.format("%s %s %s", name, lastname, surname);
    }

}
