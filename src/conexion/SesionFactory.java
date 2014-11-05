package conexion;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SesionFactory {
	public static String key = "login";
	
	private static final Map<String, SessionFactory> sessionFactorys = new HashMap<String, SessionFactory>();
	/**
	 * Atributo ???nico por threat donde se guardan las sesiones para cada uno de
	 * los ficheros de configuracion.
	 */
	private static final ThreadLocal<Map<String, Session>> sessions = new ThreadLocal<Map<String, Session>>();
	static {

		sessions.set(new HashMap<String, Session>());
	}

	public static void addConfigFile(org.w3c.dom.Document documento, String key)
			throws HibernateException {
		try {
			SessionFactory sessionFactory = new Configuration().configure(
					documento).buildSessionFactory();
			sessionFactorys.put(key, sessionFactory);
			SesionFactory.key=key;
		} catch (Exception ex) {
			ex.printStackTrace();
			throw new HibernateException(ex.getMessage());
		}
	}
	public synchronized static void setKey(String clave){
		key=clave;
	}
	public static Session getSession(String key){
		return sessionFactorys.get(key).openSession();
	}
}
