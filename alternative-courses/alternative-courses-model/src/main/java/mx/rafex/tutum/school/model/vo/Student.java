package mx.rafex.tutum.school.model.vo;

import java.io.Serializable;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class Student implements Serializable {

    private static final long serialVersionUID = 8743813932176062131L;

    private int id;

    private String name;

    private String lastname;

    private String surname;

    private boolean active;

    @Getter(AccessLevel.NONE)
    @Setter(AccessLevel.NONE)
    private String fullName;

    public Student() {
        active = true;
    }

    public Student(int id, String name, String lastname, String surname,
            boolean active) {
        super();
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.surname = surname;
        this.active = active;
    }

    public Student(int id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName = String.format("%s %s %s", name, lastname, surname);
    }

}
