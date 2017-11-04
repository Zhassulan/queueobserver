package kz.ugs.webpush.queueobserver.model;

public class Token {

	private Integer id;
	private Integer ticket_id;
	private Integer token_id;
	
	public Token ()	{
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTicket_id() {
		return ticket_id;
	}

	public void setTicket_id(Integer ticket_id) {
		this.ticket_id = ticket_id;
	}

	public Integer getToken_id() {
		return token_id;
	}

	public void setToken_id(Integer token_id) {
		this.token_id = token_id;
	}
	
	
}
