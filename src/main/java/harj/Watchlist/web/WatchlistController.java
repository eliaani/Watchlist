package harj.Watchlist.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import harj.Watchlist.domain.ApplicationUserRepository;
import harj.Watchlist.domain.Title;
import harj.Watchlist.domain.TitleRepository;
import harj.Watchlist.domain.CategoryRepository;
import harj.Watchlist.domain.SoftwareRepository;

@Controller
public class WatchlistController {
	@Autowired
	TitleRepository titleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ApplicationUserRepository userRepository;
	
	@Autowired
	SoftwareRepository softwareRepository;

	@GetMapping("watchlist")
	public String listAll(Model model) {
		model.addAttribute("Titles", titleRepository.findAll());
		return "watchlist";
	}
	
    @PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("add")
    public String addTitle(Model model){
    	model.addAttribute("add", new Title());
    	model.addAttribute("categories", categoryRepository.findAll());
    	model.addAttribute("softwares", softwareRepository.findAll());
        return "addtitle";
    }
    
    @PostMapping("save")
    public String saveTitle(Title title){
        titleRepository.save(title);
        return "redirect:watchlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteTitle(@PathVariable("id") Long id, Model model) {
    	titleRepository.deleteById(id);
        return "redirect:../watchlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editTitle(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", titleRepository.findById(id));
    	model.addAttribute("categories", categoryRepository.findAll());
    	model.addAttribute("softwares", softwareRepository.findAll());
        return "edittitle";
    }   
}