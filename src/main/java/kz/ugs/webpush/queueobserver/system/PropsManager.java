package kz.ugs.webpush.queueobserver.system;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import kz.ugs.webpush.queueobserver.App;

/**
 * Класс для получения данных из файла конфигурации приложения Spring application.properties
 * Паттерн синглтон с ленивой инициализацией (т.е. по запросу)  
 * @author Zhassulan Tokbaev
 * @version 1.0
 * @see PasswordValidator
 **/

public class PropsManager {
	/** ссылка на будущий экземпляр класса **/
	private static volatile PropsManager _instance = null;
	/** класс для обработки свойств **/
	private Properties appProps;
	
	/** конструктор 
	 * @see PropsManager()
	 * **/
	private PropsManager()	{
		appProps = new Properties();
		try {
			appProps.load(PropsManager.class.getResourceAsStream("/application.properties"));
			}
		catch (FileNotFoundException ex) {
			App.logger.error(ex.getMessage(), ex);
		}
		catch (IOException ex) {
			App.logger.error(ex.getMessage(), ex);
		}
	}
	
	/** метод получения ссылки экземпляра класса
	 * @see getInstance()
	 */
	public static synchronized PropsManager getInstance() {
        if (_instance == null)
        	 synchronized (PropsManager.class) {
                 if (_instance == null)
                     _instance = new PropsManager();
             }
        return _instance;
    }
	
	/** метод получения значения по имени свойства в конфигурации приложения
	 * @see getProperty()
	 * @param String param название параметра
	 */
	public String getProperty(String param)	{
		return appProps.getProperty(param);
	}
}
