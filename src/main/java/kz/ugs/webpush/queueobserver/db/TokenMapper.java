package kz.ugs.webpush.queueobserver.db;

import java.util.List;
import org.apache.ibatis.annotations.Select;
import kz.ugs.webpush.queueobserver.model.Token;

public interface TokenMapper {

final String getByTicketId = "select * from tokens where ticket_id = #{ticket_id}";
	
	@Select(getByTicketId)
	List <Token> getByTicketId(Integer ticket_id);
	
}
