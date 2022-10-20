package harj.Watchlist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface CategoryRepository extends CrudRepository<Category, Long> {

    List<Category> findByname(String name);
}