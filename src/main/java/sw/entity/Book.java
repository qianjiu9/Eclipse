package sw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Book {

	@Id
	@GeneratedValue
	private Long id;
	private String abbr;
	private String name;
	private String writ;
	private String desc;
	@GeneratedValue
	public Long count;
	
	@ManyToOne
	@JoinColumn
	
	private Type type;

	public Book() {

	}

	public Book(String abbr, String name, String writ, String desc) {
		super();
		this.abbr = abbr;
		this.name = name;
		this.writ = writ;
		this.desc = desc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAbbr() {
		return abbr;
	}

	public void setAbbr(String abbr) {
		this.abbr = abbr;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWrit() {
		return writ;
	}

	public void setWrit(String writ) {
		this.writ = writ;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Long getCount() {
		return  count;
	}

	public void setCount(int count) {
		this.count = (long) count;
	}

	
}
