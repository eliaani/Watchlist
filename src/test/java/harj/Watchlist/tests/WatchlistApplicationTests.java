package harj.Watchlist.tests;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

import harj.Watchlist.domain.ApplicationUserRepository;
import harj.Watchlist.domain.CategoryRepository;
import harj.Watchlist.domain.SoftwareRepository;
import harj.Watchlist.domain.Title;
import harj.Watchlist.domain.TitleRepository;
import harj.Watchlist.web.WatchlistController;

@SpringBootTest
class WatchlistApplicationTests {
	
	@Autowired
	TitleRepository titleRepository;
	
	@Autowired
	CategoryRepository categoryRepository;
	
	@Autowired
	ApplicationUserRepository userRepository;
	
	@Autowired
	SoftwareRepository softwareRepository;
	
	@Autowired
	private WatchlistController controller;

	@Test
	void contextLoads() {
	}
	
	@Test
	public void findByCategoryShouldReturnTitles() {
		List<Title> titles = titleRepository.findByCategoryName("Action");
		assertEquals(titles.size(), 1);
	}
	
	
	
	@Test
	public void ShouldBeTrue() {
		assertThat(controller, notNullValue());
	}
}
