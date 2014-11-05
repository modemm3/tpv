package transaccion;

import org.hibernate.Session;

import conexion.ConnectionHibernateMultiple;
import conexion.DB;
import conexion.DBManager;
import conexion.DBManagerImp;
import dao.AbstractDAO;
import dao.GenericDAO;
import dao.OperationsConcreteDAO;


public class TransactionImpl{

	Session currentSession;
	protected DB<Session> db=null;
	DBManager manager= new DBManagerImp();
	public TransactionImpl(String key) {
		super();
		try {
			db=manager.factoryMethod(ConnectionHibernateMultiple.class);
		} catch (ClassNotFoundException | InstantiationException
				| IllegalAccessException e) {
			e.printStackTrace();
		}
		db.setKey(key);
	}

	public Transaction launchTransaccion(Transaction t) throws Exception {
		currentSession=db.getSesion();
		currentSession.beginTransaction();
		OperationsConcreteDAO concrete= new OperationsConcreteDAO(currentSession);
		t.transaction(concrete);
		currentSession.getTransaction().commit();
		currentSession.close();
		currentSession=null;
		return t;
	}





}
