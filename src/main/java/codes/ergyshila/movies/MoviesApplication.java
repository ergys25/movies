package codes.ergyshila.movies;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
@RestController
public class MoviesApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();
        System.out.println(dotenv.get("MONGO_URI"));
        System.out.println(dotenv.get("MONGO_DB"));
        //how to load the values from the .env file to application.properties?
        System.setProperty("MONGO_URI", dotenv.get("MONGO_URI"));
        System.setProperty("MONGO_DB", dotenv.get("MONGO_DB"));


        SpringApplication.run(MoviesApplication.class, args);



    }


}
