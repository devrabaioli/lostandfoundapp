package devrabaioli;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devrabaioli.domain.Grade;
import devrabaioli.domain.Lost;
import devrabaioli.domain.enums.TypeGrade;
import devrabaioli.repositories.GradeRepository;
import devrabaioli.repositories.LostRepository;

@SpringBootApplication
public class LadappApplication implements CommandLineRunner {

	@Autowired
	private GradeRepository gradeRepo;
	
	@Autowired
	private LostRepository lostRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LadappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		Grade grad1 = new Grade(null, TypeGrade.WITHVALUE);
		Grade grad2 = new Grade(null, TypeGrade.OUTVALUE);
		
	
		
		Lost lost1 = new Lost(null, "Carteira com documentos", "Linha de caixas", "Operadora de caixa", sdf.parse("02/01/2023 12:34"), grad1);
		grad1.getLosts().addAll(Arrays.asList(lost1));
		
		Lost lost2 = new Lost(null, "Peluxe de criança", "Corredor PF", "Operador reposiçao", sdf.parse("01/01/2023 11:22"), grad2);
		grad2.getLosts().addAll(Arrays.asList(lost2));
		
		
		gradeRepo.saveAll(Arrays.asList(grad1,grad2));
		lostRepo.saveAll(Arrays.asList(lost1,lost2));
		
	}

}
