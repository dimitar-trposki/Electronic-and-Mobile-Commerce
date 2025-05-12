package mk.ukim.finki.emc.bookeshop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookEShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BookEShopApplication.class, args);
    }

    //
//    @Bean
//    PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
}
