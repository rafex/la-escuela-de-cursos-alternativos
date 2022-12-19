package mx.rafex.tutum.school.rest.config;

import java.util.logging.Logger;

import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Configuration
public class EndpointsListener
        implements ApplicationListener<ContextRefreshedEvent> {

    private final Logger LOGGER = Logger
            .getLogger(EndpointsListener.class.getName());

    @Override
    public void onApplicationEvent(final ContextRefreshedEvent event) {
        final var applicationContext = event.getApplicationContext();
        final var requestMappingHandlerMapping = applicationContext.getBean(
                "requestMappingHandlerMapping",
                RequestMappingHandlerMapping.class);
        final var map = requestMappingHandlerMapping.getHandlerMethods();
        map.forEach((key, value) -> LOGGER
                .info(String.format("{%s} {%s}", key, value)));
    }
}
