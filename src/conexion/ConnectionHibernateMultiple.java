package conexion;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;

/**
 * Clase de utilidad para conseguir la sesi???n de Hibernate. La sesi???n es ???nica
 * por thread. Pueden existir varios ficheros de configuraci???n. Al menos siempre
 * existir??? la configuraci???n por defecto sacada del fichero "hibernate.cfg.xml".
 * 
 * @author Esperanza Garcia Hernandez
 */
public class ConnectionHibernateMultiple implements DB<Session> {

	Session sesion;
	private String key;
	
//	public ConnectionHibernateMultiple(String key) {
//		this.key=key;
//	}

	public Session getSesion() throws HibernateException {

		sesion=SesionFactory.getSession(key);
		return sesion;
	}

	public void closeSession() throws HibernateException {
		sesion.close();
	}



	@Override
	public Session currentSession() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setKey(String key) {
		this.key=key;
	}




}