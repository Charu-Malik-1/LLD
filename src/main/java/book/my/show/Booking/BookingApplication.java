package book.my.show.Booking;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class BookingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookingApplication.class, args);
		System.out.println("hi");
	}

}
