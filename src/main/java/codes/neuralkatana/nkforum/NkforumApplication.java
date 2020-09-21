package codes.neuralkatana.nkforum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@EnableSpringDataWebSupport
@EnableCaching
public class NkforumApplication {

    public static void main(String[] args) {
        SpringApplication.run(NkforumApplication.class, args);
        //System.out.println("PASSWORD ENCODE:" + new BCryptPasswordEncoder().encode("123456"));
    }

}
