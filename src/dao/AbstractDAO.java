package dao;

import java.util.Collection;

import org.hibernate.Session;

import conexion.ConnectionHibernateMultiple;
import conexion.DB;
import conexion.DBManager;
import conexion.DBManagerImp;
import entity.base.EntityBase;

public abstract class AbstractDAO implements GenericDAO {

	protected Collection<EntityBase> list;
	DBManager manager= new DBManagerImp();
	DB<Session> db=null;
	Session currentSession;
	
	public AbstractDAO(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		super();
		db=manager.factoryMethod(ConnectionHibernateMultiple.class);
		db.setKey(key);
	}
	@Override
	public int size() {
		return list.size();
	}
	@Override
	public int save(EntityBase entidad) throws Exception {
		db.getSesion().save(entidad);
		return 0;
	}
	@Override
	public boolean delete(EntityBase entidad) throws Exception {
		db.getSesion().delete(entidad);
		return true;
	}
	@Override
	public boolean update(EntityBase entidad) throws Exception {
		db.getSesion().update(entidad);
		return false;
	}
	@Override
	public EntityBase find(EntityBase entidad) {
		return null;
	}
	@Override
	public Collection<EntityBase> select(EntityBase entidad) {
		return null;
	}
//	@Override
//	public transaccion.Transaction Transaction(transaccion.Transaction t) throws Exception {
//		currentSession=db.getSesion();
//		currentSession.beginTransaction();
//		t.launchTransaccion(this);
//		currentSession.getTransaction().commit();
//		currentSession.close();
//		currentSession=null;
//		return t;
////		t.launchTransaccion(this);
////		return null;
//	}
	
}
