package ptir;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = { "Service", "controllers" })
@EntityScan(basePackages = { "domain" })
@EnableJpaRepositories(basePackages = { "Repository" })
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}