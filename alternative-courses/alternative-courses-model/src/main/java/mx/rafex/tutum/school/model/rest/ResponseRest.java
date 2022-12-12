package mx.rafex.tutum.school.model.rest;

import java.io.Serializable;

import com.fasterxml.jackson.databind.JsonNode;

import lombok.Data;

@Data
public class ResponseRest implements Serializable {

    private static final long serialVersionUID = 3089806448344923303L;

    private String message;
    private String status;
    private JsonNode data;

}
