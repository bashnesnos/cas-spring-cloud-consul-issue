package issues.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {

    @Bean
    public HeartbeatPropertiesMinimumFailure heartbeatProperties() {
        return new HeartbeatPropertiesMinimumFailure();
    }

    @Bean
    public CustomBeanValidationPostProcessor beanValidationPostProcessor() {
        return new CustomBeanValidationPostProcessor();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}