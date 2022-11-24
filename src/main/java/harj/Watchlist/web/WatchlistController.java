package harj.Watchlist.web;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	@GetMapping("/error")
	public String errorpage(Model model) {
		return "error";
	}
	
	@GetMapping("watchedlist")
	public String listAllWatched(Model model) {
		model.addAttribute("Titles", titleRepository.findAll());
		return "watchedlist";
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
    public String saveTitle(@Valid @ModelAttribute("add")Title title, BindingResult bindingresult, Model model){
    	boolean thereAreErrors = bindingresult.hasErrors();
    	if (thereAreErrors) {
        	model.addAttribute("categories", categoryRepository.findAll());
        	model.addAttribute("softwares", softwareRepository.findAll());
    		return "addtitle";
    	}
        titleRepository.save(title);
        return "redirect:watchlist";
    }
    
    @PostMapping("savewatched")
    public String saveWatchedtitle(@Valid @ModelAttribute("add")Title title, BindingResult bindingresult, Model model){
    	boolean thereAreErrors = bindingresult.hasErrors();
    	if (thereAreErrors) {
        	model.addAttribute("categories", categoryRepository.findAll());
        	model.addAttribute("softwares", softwareRepository.findAll());
    		return "addtitle";
    	}
        titleRepository.save(title);
        return "redirect:watchedlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteTitle(@PathVariable("id") Long id, Model model) {
    	titleRepository.deleteById(id);
        return "redirect:../watchlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/deletewatched/{id}")
    public String deleteWatchedTitle(@PathVariable("id") Long id, Model model) {
    	titleRepository.deleteById(id);
        return "redirect:../watchedlist";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editTitle(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", titleRepository.findById(id));
    	model.addAttribute("categories", categoryRepository.findAll());
    	model.addAttribute("softwares", softwareRepository.findAll());
        return "edittitle";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/watched/{id}")
    public String watched(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", titleRepository.findById(id));
    	model.addAttribute("categories", categoryRepository.findAll());
    	model.addAttribute("softwares", softwareRepository.findAll());
    	titleRepository.findById(id).ifPresent(o -> model.addAttribute("tittel", o));
        return "watched";
    }
    
    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/editwatched/{id}")
    public String editwatchedTitle(@PathVariable("id") Long id, Model model) {
    	model.addAttribute("edit", titleRepository.findById(id));
    	model.addAttribute("categories", categoryRepository.findAll());
    	model.addAttribute("softwares", softwareRepository.findAll());
        return "editwatchedtitle";
    }
    
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/listbycategory/{id}")
	public String listbyCategory(@PathVariable("id") Long id, Model model) {
		model.addAttribute("title", titleRepository.findAll());
		categoryRepository.findById(id).ifPresent(o -> model.addAttribute("category", o));
		return "listbycategory";
	}
		
	@PreAuthorize("hasAuthority('ADMIN')")
	@GetMapping("/listbycategorywatched/{id}")
	public String listbyCategorywatched(@PathVariable("id") Long id, Model model) {
		model.addAttribute("title", titleRepository.findAll());
		categoryRepository.findById(id).ifPresent(o -> model.addAttribute("category", o));
		return "listbycategorywatched";


	}
}