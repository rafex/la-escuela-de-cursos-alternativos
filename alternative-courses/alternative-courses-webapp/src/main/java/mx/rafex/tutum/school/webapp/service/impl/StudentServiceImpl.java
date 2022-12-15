package mx.rafex.tutum.school.webapp.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import mx.rafex.tutum.school.model.rest.ResponseRest;
import mx.rafex.tutum.school.model.rest.ScoreRequestRest;
import mx.rafex.tutum.school.model.rest.StudentRequestRest;
import mx.rafex.tutum.school.model.rest.SubjectRest;
import mx.rafex.tutum.school.model.vo.Student;
import mx.rafex.tutum.school.model.vo.Subject;
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

                    var listRest = objectMapper.convertValue(
                            responseObject.getData(),
                            new TypeReference<List<StudentRequestRest>>() {
                            });

                    list = MAPPER.restToStudents(listRest);

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

    @Override
    public List<Subject> getSubjects(final int idStudent) {

        url = "/api/v01/student/{idStudent}/subject";

        List<Subject> list = new ArrayList<>();

        final Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("idStudent", String.valueOf(idStudent));

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

                    list = objectMapper.convertValue(
                            responseObject.getData().get("subjects"),
                            new TypeReference<List<Subject>>() {
                            });

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

    @Override
    public void saveScore(final int idStudent, final List<Subject> subjects) {

        url = "/api/v01/student/{idStudent}/subject";

        final Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("idStudent", String.valueOf(idStudent));

        final var request = new ScoreRequestRest();

        final List<SubjectRest> subjectsRest = new ArrayList<>();

        subjects.forEach(s -> {
            subjectsRest.add(SUBJECT_MAPPER.subjectToRest(s));
        });

        request.setSubjects(subjectsRest);

        try {

            final var plainJson = objectMapper.writeValueAsString(request);

            final var headers = new HttpHeaders();
            headers.set(CONTENT_TYPE, APPLICATION_JSON_UTF8);
            final var entity = new HttpEntity<>(plainJson, headers);
            final ResponseEntity<String> response = restTemplate.exchange(
                    getUrl(), HttpMethod.PUT, entity, String.class,
                    uriVariables);

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

                } catch (final NullPointerException
                        | JsonProcessingException e) {
                    LOGGER.info(e.getMessage());
                }
            }

        } catch (final Exception e) {
            LOGGER.info(e.getMessage());
        }

    }

}
