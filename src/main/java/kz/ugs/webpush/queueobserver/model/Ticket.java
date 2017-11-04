package kz.ugs.webpush.queueobserver.model;

import java.sql.Timestamp;

public class Ticket {

	private Integer id;
	private String uid;
	private Integer number;
	private Timestamp create_date;
	private boolean overdue;
	private boolean realized;
	private Timestamp visit_time;
	private Integer service_id;
	
	public Ticket ()	{
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUid() {
		return uid;
	}

	public void setUid(String uid) {
		this.uid = uid;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public boolean isOverdue() {
		return overdue;
	}

	public void setOverdue(boolean overdue) {
		this.overdue = overdue;
	}

	public boolean isRealized() {
		return realized;
	}

	public void setRealized(boolean realized) {
		this.realized = realized;
	}

	public Timestamp getVisit_time() {
		return visit_time;
	}

	public void setVisit_time(Timestamp visit_time) {
		this.visit_time = visit_time;
	}

	public Integer getService_id() {
		return service_id;
	}

	public void setService_id(Integer service_id) {
		this.service_id = service_id;
	}
	
	
}
