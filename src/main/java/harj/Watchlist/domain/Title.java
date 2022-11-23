package harj.Watchlist.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
public class Title {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@NotEmpty
	private String name;
	
	@NotEmpty
	private String recommend;
	
	private String type;
	private String watched;
	private int grade;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="categoryid")
	private Category category;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="softwareid")
	private Software software;
	
	public Title() {
		super();
	}
	
	public Title(String name, String recommend ,String type , int grade ,Category category, Software software, String watched) {
		super();
		this.name = name;
		this.recommend = recommend;
		this.software = software;
		this.type = type;
		this.grade = grade;
		this.category = category;
		this.watched = watched;
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRecommend() {
		return recommend;
	}

	public void setRecommend(String recommend) {
		this.recommend = recommend;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
	
	public Software getSoftware() {
		return software;
	}

	public void setSoftware(Software software) {
		this.software = software;
	}
	
	public String getWatched() {
		return watched;
	}

	public void setWatched(String watched) {
		this.watched = watched;
	}

}