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

		};
	}
}