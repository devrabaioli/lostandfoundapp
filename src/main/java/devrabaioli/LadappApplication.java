package devrabaioli;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import devrabaioli.domain.Found;
import devrabaioli.domain.FoundClient;
import devrabaioli.domain.Grade;
import devrabaioli.domain.Lost;
import devrabaioli.domain.Ordered;
import devrabaioli.domain.UserApp;
import devrabaioli.domain.WhoFind;
import devrabaioli.domain.enums.StateFound;
import devrabaioli.domain.enums.TypeGrade;
import devrabaioli.domain.enums.TypeUserApp;
import devrabaioli.repositories.FoundRepository;
import devrabaioli.repositories.GradeRepository;
import devrabaioli.repositories.LostRepository;
import devrabaioli.repositories.OrderedRepository;
import devrabaioli.repositories.UserAppRepository;
import devrabaioli.repositories.WhoFindRepository;

@SpringBootApplication
public class LadappApplication implements CommandLineRunner {

	@Autowired
	private GradeRepository gradeRepo;
	
	@Autowired
	private LostRepository lostRepo;
	
	@Autowired
	private UserAppRepository userAppRepo;
	
	@Autowired
	private WhoFindRepository whoFindRepo;
	
	@Autowired
	private OrderedRepository orderedRepo;
	
	@Autowired
	private FoundRepository foundRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(LadappApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		WhoFind whoFind1 = new WhoFind(null, "Operadora Caixa X", TypeUserApp.EMPLOYEE);
		WhoFind whoFind2 = new WhoFind(null, "Operador de armazém", TypeUserApp.EMPLOYEE);
		
		Grade grad1 = new Grade(null, TypeGrade.WITHVALUE);
		Grade grad2 = new Grade(null, TypeGrade.OUTVALUE);
		
		UserApp userapp1 = new UserApp(null, "Hélio Silva", "helio@mail.com", TypeUserApp.EMPLOYEE);
		UserApp userapp2 = new UserApp(null, "Alexandre Santos","alexandre@mail.com", TypeUserApp.EMPLOYEE);
		UserApp userapp3 = new UserApp(null, "Fábio Costa","fabio@mail.com", TypeUserApp.EMPLOYEE);
		UserApp userapp4 = new UserApp(null, "José Carlos", "josecarlos@mail.com",TypeUserApp.EMPLOYEE);
		UserApp userapp5 = new UserApp(null, "Erika Oliveira", "erika@mail.com",TypeUserApp.EMPLOYEE);
		
		
		Lost lost1 = new Lost(null, "Carteira com documentos", "Linha de caixas", sdf.parse("02/01/2023 12:34"), grad1,whoFind1);
		whoFind1.setLost(lost1);
		grad1.getLosts().addAll(Arrays.asList(lost1));
		
		
		Lost lost2 = new Lost(null, "Peluxe de criança", "Corredor PF", sdf.parse("01/01/2023 11:22"), grad2,whoFind2);
		whoFind2.setLost(lost2);
		grad2.getLosts().addAll(Arrays.asList(lost2));
		
		Ordered ordered1 = new Ordered(null, sdf.parse("03/01/2023 10:23"),userapp1 );
		Ordered ordered2 = new Ordered(null, sdf.parse("03/01/2023 11:37"), userapp2);
		
		Found found1 = new FoundClient(null, StateFound.DELIVERY, ordered1, "Maria Amelia", "Amadora", sdf.parse("03/01/2023 10:25"));
		ordered1.setFound(found1);
		
		Found found2 = new FoundClient(null, StateFound.DELIVERY, ordered2, "Vera Curz", "Lisboa", sdf.parse("03/01/2023 11:40"));
		ordered2.setFound(found2);
		
		
		
		
		gradeRepo.saveAll(Arrays.asList(grad1,grad2));
		whoFindRepo.saveAll(Arrays.asList(whoFind1, whoFind2));
		lostRepo.saveAll(Arrays.asList(lost1,lost2));
		userAppRepo.saveAll(Arrays.asList(userapp1,userapp2, userapp3, userapp4, userapp5));
		orderedRepo.saveAll(Arrays.asList(ordered1,ordered2));
		foundRepo.saveAll(Arrays.asList(found1,found2));
		
		
	}

}
