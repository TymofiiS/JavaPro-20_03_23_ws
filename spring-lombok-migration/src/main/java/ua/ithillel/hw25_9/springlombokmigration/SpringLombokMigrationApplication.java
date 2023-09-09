package ua.ithillel.hw25_9.springlombokmigration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLombokMigrationApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringLombokMigrationApplication.class, args);
		
		SeederDb seederDb = new SeederDb();
		seederDb.seeding();
	}

}
