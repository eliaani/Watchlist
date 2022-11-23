package harj.Watchlist;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import harj.Watchlist.domain.ApplicationUser;
import harj.Watchlist.domain.ApplicationUserRepository;
import harj.Watchlist.domain.Title;
import harj.Watchlist.domain.TitleRepository;
import harj.Watchlist.domain.Category;
import harj.Watchlist.domain.CategoryRepository;
import harj.Watchlist.domain.Software;
import harj.Watchlist.domain.SoftwareRepository;

@SpringBootApplication
public class WatchlistApplication {

	private static final Logger log = LoggerFactory.getLogger(WatchlistApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(WatchlistApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner BookStuff(TitleRepository titleRepository, CategoryRepository categoryRepository, ApplicationUserRepository applicationUserRepository, SoftwareRepository softwareRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Action"));
			categoryRepository.save(new Category("Sci-fi"));
			categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Crime"));
			categoryRepository.save(new Category("-"));
			
			softwareRepository.save(new Software("Netflix"));
			softwareRepository.save(new Software("HBO"));
			softwareRepository.save(new Software("Disney+"));
			softwareRepository.save(new Software("Youtube"));
			softwareRepository.save(new Software("-"));
			
			titleRepository.save(new Title("leffa1", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "Yes" ));
			titleRepository.save(new Title("leffa2", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "Yes" ));
			titleRepository.save(new Title("leffa3", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "Yes" ));
			titleRepository.save(new Title("leffa4", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "Yes" ));
			titleRepository.save(new Title("leffa5", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("leffa6", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("leffa7", "Teemu","Movie", 10 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("sarja1", "Stefan","Series", 10 , categoryRepository.findByname("Comedy").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("sarja2", "Stefan","Series", 10 , categoryRepository.findByname("Comedy").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("sarja3", "Stefan","Series", 10 , categoryRepository.findByname("Sci-fi").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("sarja4", "Stefan","Series", 10 , categoryRepository.findByname("Sci-fi").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			
			
			applicationUserRepository.save(new ApplicationUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			applicationUserRepository.save(new ApplicationUser("user", "$2a$10$hss2sI4wBehMqUWVJslFleDQxOs9txWVFW7bvwtrchiuwvEAgnx1.", "USER"));
			

		};
	}
}