package kz.ugs.webpush.queueobserver.db;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import kz.ugs.webpush.queueobserver.model.Service;

public interface ServiceMapper {
	
	final String getAll = "select * from service where parent_id is not null";
	
	final String getByLogin = "select * from clients where login = #{login}";
	final String add = "insert into clients (login, password) values (#{login}, #{password})";
	final String getByLoginAndPassword = "select * from clients where login = #{login} "
										+ "and password = #{password}";
	
	@Select(getAll)
	List <Service> getAll();
		
	@Select(getByLogin)
	List <Service> getByLogin(String login);
	
	@Insert(add)
	@Options(useGeneratedKeys = true, keyProperty = "id")
	void add(Service client);
	
	@Select(getByLoginAndPassword)
	List <Service> getByLoginAndPassword(@Param("login")String login, @Param("password")String password);
}
