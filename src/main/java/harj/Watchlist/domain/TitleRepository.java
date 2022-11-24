package harj.Watchlist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface TitleRepository extends CrudRepository<Title, Long> {

    List<Title> findByid(Long Id);
    
    List<Title> findByCategoryName(String category);
}