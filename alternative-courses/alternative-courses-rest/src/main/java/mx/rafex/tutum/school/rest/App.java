package mx.rafex.tutum.school.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@ServletComponentScan
@SpringBootApplication(scanBasePackages = { "mx.rafex.tutum.school.rest",
        "mx.rafex.tutum.school.service" })
@EnableJpaRepositories("mx.rafex.tutum.school.repository")
@EntityScan("mx.rafex.tutum.school.model.entity")
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

}
