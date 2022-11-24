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
	public CommandLineRunner watchlistApp(TitleRepository titleRepository, CategoryRepository categoryRepository, ApplicationUserRepository applicationUserRepository, SoftwareRepository softwareRepository) {
		return (args) -> {
			categoryRepository.save(new Category("Action"));
			categoryRepository.save(new Category("Sci-fi"));
			categoryRepository.save(new Category("Comedy"));
			categoryRepository.save(new Category("Drama"));
			categoryRepository.save(new Category("Crime"));
			categoryRepository.save(new Category("Romance"));
			categoryRepository.save(new Category("Adventure"));
			categoryRepository.save(new Category("Horror"));
			categoryRepository.save(new Category("Fantasy"));
			
			softwareRepository.save(new Software("Netflix"));
			softwareRepository.save(new Software("HBO"));
			softwareRepository.save(new Software("Disney+"));
			softwareRepository.save(new Software("Youtube"));
			softwareRepository.save(new Software("Prime video"));
			softwareRepository.save(new Software("None"));
			
			titleRepository.save(new Title("Die Hard", "Teemu","Movie", 0 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("Netflix").get(0), "No" ));
			titleRepository.save(new Title("Die Hard 2", "Teemu","Movie", 0 , categoryRepository.findByname("Action").get(0), softwareRepository.findByname("Netflix").get(0), "No" ));
			titleRepository.save(new Title("It", "Teemu","Movie", 6 , categoryRepository.findByname("Horror").get(0), softwareRepository.findByname("Netflix").get(0), "Yes" ));
			titleRepository.save(new Title("Game of thrones", "Teemu","Series", 8 , categoryRepository.findByname("Fantasy").get(0), softwareRepository.findByname("HBO").get(0), "Yes" ));
			titleRepository.save(new Title("Expanse", "Teemu","Series", 0 , categoryRepository.findByname("Sci-fi").get(0), softwareRepository.findByname("Prime video").get(0), "No" ));
			titleRepository.save(new Title("Friends", "Teemu","Series", 0 , categoryRepository.findByname("Comedy").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("Brooklyn 99", "Teemu","Series", 0 , categoryRepository.findByname("Comedy").get(0), softwareRepository.findByname("Netflix").get(0), "No" ));
			titleRepository.save(new Title("The good place", "Stefan","Series", 0 , categoryRepository.findByname("Comedy").get(0), softwareRepository.findByname("Netflix").get(0), "No" ));
			titleRepository.save(new Title("Ozark", "Stefan","Series", 0 , categoryRepository.findByname("Crime").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			titleRepository.save(new Title("Witcher", "Stefan","Series", 0 , categoryRepository.findByname("Fantasy").get(0), softwareRepository.findByname("Netflix").get(0), "No" ));
			titleRepository.save(new Title("Rick and Morty", "Stefan","Series", 0 , categoryRepository.findByname("Sci-fi").get(0), softwareRepository.findByname("HBO").get(0), "No" ));
			
			
			applicationUserRepository.save(new ApplicationUser("admin", "$2a$10$0MMwY.IQqpsVc1jC8u7IJ.2rT8b0Cd3b3sfIBGV2zfgnPGtT4r0.C", "ADMIN"));
			applicationUserRepository.save(new ApplicationUser("user", "$2a$10$hss2sI4wBehMqUWVJslFleDQxOs9txWVFW7bvwtrchiuwvEAgnx1.", "USER"));
			

		};
	}
}