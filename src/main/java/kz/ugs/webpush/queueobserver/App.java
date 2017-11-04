package kz.ugs.webpush.queueobserver;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kz.ugs.webpush.queueobserver.model.*;
import kz.ugs.webpush.queueobserver.db.DatabaseManager;

/**
 * Hello world!
 *
 */
public class App	{
	
	public static Logger logger = LogManager.getLogger(App.class);
	
    public static void main( String[] args )	{
    	List <Service> services = DatabaseManager.getInstance().getAll();
    	List <Ticket> tickets = null;
    	for (Service service : services) {
			logger.info(service.getName());
			tickets = DatabaseManager.getInstance().getByServiceId(service.getId());
			for (Ticket ticket :tickets) {
				logger.info(ticket.getNumber());	
			}
		}
    }
}
