package dao;

import java.util.Collection;

import org.hibernate.Session;

public class OperationsConcreteDAO implements GenericOperactionsDAO{

	Session currentSession;
	public OperationsConcreteDAO(Session currentSession) {
		super();
		this.currentSession=currentSession;
	}

	@Override
	public <T> int save(T entidad) throws Exception {
		currentSession.save(entidad);
		return 1;
	}

	@Override
	public <T> boolean delete(T entidad) throws Exception {
		currentSession.delete(entidad);
		return true;
	}

	@Override
	public <T> boolean update(T entidad) throws Exception {
		currentSession.update(entidad);
		return true;
	}

	@Override
	public <T> T find(T entidad) throws Exception {
		return null;
	}

	@Override
	public <T> Collection<T> select(T entidad) throws Exception {
		return null;
	}


}
