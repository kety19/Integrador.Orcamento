	package integradorService;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestConfig {


    @Bean
    public SomarService somarService() {
        return new SomarService();
    }
}
