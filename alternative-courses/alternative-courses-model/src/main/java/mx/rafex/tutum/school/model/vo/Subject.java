package mx.rafex.tutum.school.model.vo;

import java.io.Serializable;

import lombok.Data;

@Data
public class Subject implements Serializable {

    private static final long serialVersionUID = -6664347524855261529L;

    private int id;

    private String name;

    private boolean active;

}
