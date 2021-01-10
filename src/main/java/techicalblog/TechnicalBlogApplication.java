package techicalblog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TechnicalBlogApplication {
    public static void main(String [] args){

        SpringApplication.run(TechnicalBlogApplication.class, args);
    }
}
