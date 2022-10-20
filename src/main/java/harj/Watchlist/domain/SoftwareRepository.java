package harj.Watchlist.domain;

import java.util.List;
import org.springframework.data.repository.CrudRepository;


public interface SoftwareRepository extends CrudRepository<Software, Long> {

    List<Software> findByname(String name);
}