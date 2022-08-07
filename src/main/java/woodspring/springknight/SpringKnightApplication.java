package woodspring.springknight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@SpringBootApplication
@EnableFeignClients("woodspring.springknight")  
public class SpringKnightApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringKnightApplication.class, args);
	}

}
