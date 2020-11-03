package codes.neuralkatana.nkforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
@EnableSwagger2
public class NkforumApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(NkforumApplication.class, args);
        //System.out.println("PASSWORD ENCODE:" + new BCryptPasswordEncoder().encode("123456"));
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(NkforumApplication.class);
    }
}
