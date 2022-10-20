package harj.Watchlist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface ApplicationUserRepository extends CrudRepository<ApplicationUser, Long> {
	
	ApplicationUser findByUsername(String username);
}