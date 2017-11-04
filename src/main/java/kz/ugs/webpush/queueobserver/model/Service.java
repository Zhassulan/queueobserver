package kz.ugs.webpush.queueobserver.model;

import java.sql.Timestamp;

public class Service {

	private Integer id;
	private String name;
	private Integer parent_id;

	public Service()	{
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getParent_id() {
		return parent_id;
	}

	public void setParent_id(Integer parent_id) {
		this.parent_id = parent_id;
	}
	
	
}
