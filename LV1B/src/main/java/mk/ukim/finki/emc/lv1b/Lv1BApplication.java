package mk.ukim.finki.emc.lv1b;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class Lv1BApplication {

    public static void main(String[] args) {
        SpringApplication.run(Lv1BApplication.class, args);
    }

//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
}
