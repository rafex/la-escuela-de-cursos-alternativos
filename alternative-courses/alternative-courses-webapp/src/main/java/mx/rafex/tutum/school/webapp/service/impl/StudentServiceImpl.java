package mx.rafex.tutum.school.webapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.rafex.tutum.school.model.rest.ResponseRest;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.webapp.service.ABaseService;
import mx.rafex.tutum.school.webapp.service.StudentService;

@Service
public class StudentServiceImpl extends ABaseService implements StudentService {

    private static final Logger LOGGER = Logger
            .getLogger(StudentServiceImpl.class.getName());

    public StudentServiceImpl(final RestTemplate restTemplate,
            final ObjectMapper objectMapper, final Environment environment) {
        super(restTemplate, objectMapper, environment);
    }

    @Override
    public List<Student> list(final Object keyword) {

        url = "/api/v01/student";

        List<Student> list = new ArrayList<>();

        final Map<String, String> uriVariables = new HashMap<>();
//        uriVariables.put("country", country.getCodeOnBoard().toString());

        try {

//            LOGGER.info(String.format("Raw data:\n%s",
//                    objectMapper.writeValueAsString(data)));

            final ResponseEntity<Object> response = restTemplate
                    .getForEntity(getUrl(), Object.class, uriVariables);

            LOGGER.info(response.toString());

            if (response.getStatusCodeValue() >= 200
                    && response.getStatusCodeValue() < 300) {

                try {

                    final var body = response.getBody();

                    final var jsonResult = objectMapper
                            .writeValueAsString(body);

                    LOGGER.info(jsonResult);

                    final var responseObject = objectMapper
                            .readValue(jsonResult, ResponseRest.class);

                    LOGGER.info(responseObject.toString());

                    list = objectMapper.convertValue(responseObject.getData(),
                            new TypeReference<List<Student>>() {
                            });

//                    final String jsonStr = objectMapper
//                            .writeValueAsString(response.getBody());

//                    return objectMapper.readTree(jsonStr);
                } catch (final NullPointerException
                        | JsonProcessingException e) {
                    LOGGER.info(e.getMessage());
                }
            }

        } catch (final Exception e) {
            LOGGER.info(e.getMessage());
        }
        return list;
    }

}
