package conexion;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.w3c.dom.Document;

public class ConexionHibernateSimple implements DB<Session> {

	private static final SessionFactory sessionFactory = buildSessionFactory();
	private Session sesion;
	private static SessionFactory buildSessionFactory() {
		try {
			return new Configuration().configure("resources/hibernate.cfg.xml").buildSessionFactory();
		} catch (HibernateException he) {
			System.err.println("Ocurrió un error en la inicialización de la SessionFactory: "+ he);
			throw new ExceptionInInitializerError(he);
		}
	}

	
	@Override
	public Session getSesion() throws Exception{
		sesion=sessionFactory.openSession();
		return sesion;
	}

	@Override
	public void closeSession() {
		if(sesion.isOpen()){
			sesion.close();
			sesion=null;
		}
	}

	@Override
	public Session currentSession() {
		return sesion;
	}


	@Override
	public void setKey(String key) {
		// TODO Auto-generated method stub
		
	}




}
