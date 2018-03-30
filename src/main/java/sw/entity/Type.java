package sw.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


@Entity
public class Type {
	
	@Id
	@GeneratedValue
	private Long id;
	private String abbr;
	private String name;
	private String desc;

	public Type() {
	}

	public Type(String abbr,String name,String desc){
		super();
		this.abbr=abbr;
		this.name=name;
		this.desc=desc;
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

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

}
