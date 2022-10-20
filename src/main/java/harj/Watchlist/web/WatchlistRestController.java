package harj.Watchlist.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import harj.Watchlist.domain.Title;
import harj.Watchlist.domain.TitleRepository;
import harj.Watchlist.domain.CategoryRepository;

@RestController
public class WatchlistRestController {
	
	@Autowired
	TitleRepository titleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
    @RequestMapping(value="/titles", method = RequestMethod.GET)
    public List<Title> bookListRest() {	
        return (List<Title>) titleRepository.findAll();
    }    

    @RequestMapping(value="/title/{id}", method = RequestMethod.GET)
    public Optional<Title> findStudentRest(@PathVariable("id") Long titleId) {	
    	return titleRepository.findById(titleId);
    }    
}
