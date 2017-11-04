package kz.ugs.webpush.queueobserver.db;

import java.util.List;
import org.apache.ibatis.annotations.*;

import kz.ugs.webpush.queueobserver.model.Ticket;


public interface TicketMapper {

	final String getByServiceId = "select * from ticket where service_id = #{serviceId} and realized = false";
	
	final String getByLogin = "select * from clients where login = #{login}";
	final String add = "insert into clients (login, password) values (#{login}, #{password})";
	final String getByLoginAndPassword = "select * from clients where login = #{login} "
										+ "and password = #{password}";
	
	@Select(getByServiceId)
	List <Ticket> getByServiceId(Integer serviceId);
	
	@Select(getByLogin)
	List <Ticket> getByLogin(String login);
	
	@Insert(add)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void add(Ticket client);
	
	@Select(getByLoginAndPassword)
	List <Ticket> getByLoginAndPassword(@Param("login")String login, @Param("password")String password);
}
