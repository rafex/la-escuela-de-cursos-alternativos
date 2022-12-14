package mx.rafex.tutum.school.webapp.service;

import java.util.logging.Logger;

import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class ABaseService {

    protected static final Logger LOGGER = Logger
            .getLogger(ABaseService.class.getName());

    protected RestTemplate restTemplate;
    protected Environment environment;
    protected ObjectMapper objectMapper;
    protected String urlBase;
    protected String url;
    protected String APPLICATION_JSON_UTF8 = "application/json; charset=utf-8";
    protected String CONTENT_TYPE = "Content-type";

    private final String HARD_URL_BASE = "http://34.28.12.213";

    public ABaseService(final RestTemplate restTemplate,
            final ObjectMapper objectMapper, final Environment environment) {
        this.restTemplate = restTemplate;
        this.environment = environment;
        this.objectMapper = objectMapper;
        try {
            urlBase = environment.getProperty("url.base") != null
                    ? environment.getProperty("url.base")
                    : HARD_URL_BASE;
        } catch (final NullPointerException ex) {
            LOGGER.info(ex.getMessage());
            urlBase = HARD_URL_BASE;
        }
    }

    public String getUrl(final String... str) {

        final StringBuilder sb = new StringBuilder(urlBase);

        if (url != null && !url.isEmpty()) {
            sb.append(url);
        }

        for (final String s : str) {
            if (s != null && !s.isEmpty()) {
                sb.append(s);
            }
        }

        return sb.toString();
    }

    public String getUrl() {
        final String[] array = new String[0];
        return getUrl(array);
    }

}
