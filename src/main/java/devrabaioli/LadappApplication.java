package devrabaioli;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devrabaioli.domain.Grade;
import devrabaioli.domain.enums.TypeGrade;
import devrabaioli.repositories.GradeRepository;

@SpringBootApplication
public class LadappApplication implements CommandLineRunner {

	@Autowired
	private GradeRepository gradeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LadappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		Grade grad1 = new Grade(null, TypeGrade.WITHVALUE);
		Grade grad2 = new Grade(null, TypeGrade.OUTVALUE);
		
		
		gradeRepo.saveAll(Arrays.asList(grad1,grad2));
	}

}
