package be.tibo.taskmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class TaskmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskmanagerApplication.class, args);
    }

    // I placed this in the DemoApplication class and not in the
    //SecurityConfig class, since otherwise a circular autowiring dependency would occur and the
    //application would not be able to start.
    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }
}
