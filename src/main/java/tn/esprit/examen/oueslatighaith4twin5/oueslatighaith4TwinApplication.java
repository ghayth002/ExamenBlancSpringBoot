package tn.esprit.examen.oueslatighaith4twin5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAspectJAutoProxy
@EnableScheduling
@SpringBootApplication
public class oueslatighaith4TwinApplication {

    public static void main(String[] args) {
        SpringApplication.run(oueslatighaith4TwinApplication.class, args);
    }

}
