package kz.ugs.webpush.queueobserver.db;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kz.ugs.webpush.queueobserver.App;
import kz.ugs.webpush.queueobserver.model.*;

import java.io.Reader;
import java.util.List;

public class DatabaseManager {
	
	private static volatile DatabaseManager _instance = null;
	private static SqlSessionFactory sqlSessionFactory;
	private static ServiceMapper ServiceMapper;
	private static TicketMapper TicketMapper;
	private static TokenMapper TokenMapper;
	private static Reader reader = null;
	
	static {
		try {
			reader = Resources.getResourceAsReader("mybatis-config.xml");
	        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
		}
		catch	(Exception ex)
		{
			App.logger.error(ex.getMessage(), ex);
		}
	}
	
	private DatabaseManager()	{
		try	(SqlSession session = sqlSessionFactory.openSession()) 	{
			//adding annotated mappers
			session.getConfiguration().addMapper(TicketMapper.class);
			session.getConfiguration().addMapper(ServiceMapper.class);
			}
			catch	(Exception ex)
			{
				App.logger.error(ex.getMessage(), ex);
			}
	}
	
	public static synchronized DatabaseManager getInstance() {
        if (_instance == null)
        	 synchronized (DatabaseManager.class) {
                 if (_instance == null)
                     _instance = new DatabaseManager();
             }
        return _instance;
    }
	
	public List<Service> getAll()	{
		List <Service> services = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			ServiceMapper = session.getMapper(ServiceMapper.class);
			services = ServiceMapper.getAll();
		}
		catch	(Exception ex)
		{
			App.logger.error(ex.getMessage(), ex);
		}	
		return services;
	}
	
	public List<Ticket> getByServiceId(Integer serviceId)	{
		List <Ticket> tickets = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			TicketMapper = session.getMapper(TicketMapper.class);
			tickets = TicketMapper.getByServiceId(serviceId);
		}
		catch	(Exception ex)
		{
			App.logger.error(ex.getMessage(), ex);
		}	
		return tickets;
	}
	
	public List<Token> getByTicketId(Integer ticket_id)	{
		List <Token> tokens = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			TokenMapper = session.getMapper(TokenMapper.class);
			tokens = TokenMapper.getByTicketId(ticket_id);
		}
		catch	(Exception ex)
		{
			App.logger.error(ex.getMessage(), ex);
		}	
		return tokens;
	}
	
	public List<Ticket> GetTicketByLogin(String login)	{
		List <Ticket> Tickets = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			TicketMapper = session.getMapper(TicketMapper.class);
			Tickets = TicketMapper.getByLogin(login);
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message in GetTicketByLogin: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}	
		return Tickets;
	}
	
	public List<Ticket> GetTicketByLoginAndPassword(String login, String password)	{
		List <Ticket> Tickets = null;
		try	(SqlSession session = sqlSessionFactory.openSession())	{
			TicketMapper = session.getMapper(TicketMapper.class);
			Tickets = TicketMapper.getByLoginAndPassword(login, password);
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message in GetTicketByLoginAndPassword: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
		}	
		return Tickets;
	}
	
	public boolean addTicket(Ticket Ticket)	{
		try(SqlSession session = sqlSessionFactory.openSession()) {
			TicketMapper = session.getMapper(TicketMapper.class);
			TicketMapper.add(Ticket);
			session.commit();
			return true;
		}
		catch	(Exception ex)
		{
			App.logger.info("Error message in addTicket: " + ex.getMessage());
			App.logger.error("Stack trace: ", ex);
			return false;
		}
	}
	
}
