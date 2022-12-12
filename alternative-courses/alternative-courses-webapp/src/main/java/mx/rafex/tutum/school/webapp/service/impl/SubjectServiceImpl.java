package mx.rafex.tutum.school.webapp.service.impl;

import java.util.List;
import java.util.logging.Logger;

import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import mx.rafex.tutum.school.model.vo.Subject;
import mx.rafex.tutum.school.webapp.service.ABaseService;
import mx.rafex.tutum.school.webapp.service.SubjectService;

@Service
public class SubjectServiceImpl extends ABaseService implements SubjectService {

    private static final Logger LOGGER = Logger
            .getLogger(SubjectServiceImpl.class.getName());

    public SubjectServiceImpl(RestTemplate restTemplate,
            ObjectMapper objectMapper, Environment environment) {
        super(restTemplate, objectMapper, environment);
    }

    @Override
    public List<Subject> list(int idStudent) {
        // TODO Auto-generated method stub
        return null;
    }

}
