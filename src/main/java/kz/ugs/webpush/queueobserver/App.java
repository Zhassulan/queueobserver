package kz.ugs.webpush.queueobserver;

import java.util.Iterator;
import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import kz.ugs.webpush.queueobserver.model.*;
import kz.ugs.webpush.queueobserver.system.PropsManager;
import kz.ugs.webpush.queueobserver.db.DatabaseManager;
import kz.ugs.webpush.sender.Sender;

/**
 * Hello world!
 *
 */
public class App	{
	
	public static Logger logger = LogManager.getLogger(App.class);
	
    public static void main( String[] args )	{
    	String tokenStr = "fS_17t7lZNw:APA91bEcSN7rH-gWAO375e39uO90C1hYKkaF7a9BqqLEMvWiwwliy4deRW6OvNmVNTIr-_4XogFunYQU1Sxg6M7z_7begXIl_H__BugVwwFjk8Y61fDd3EokrcNbyYvV7XlIH-haa_7E";
    	Sender sender = new Sender(PropsManager.getInstance().getProperty("fcm.key"), tokenStr, "1");
    	List <Service> services = DatabaseManager.getInstance().getAll();
    	List <Ticket> tickets = null;
    	List <Token> tokens = null;
    	for (Service service : services) {
			logger.info("service: " + service.getName());
			tickets = DatabaseManager.getInstance().getByServiceId(service.getId());
			for (Ticket ticket :tickets) {
				logger.info("ticket: " + ticket.getNumber());
				tokens = DatabaseManager.getInstance().getByTicketId(ticket.getNumber());
				for (Token token : tokens) {
					logger.info("token: " + token.getToken_id());
				}
			}
		}
    }
}
