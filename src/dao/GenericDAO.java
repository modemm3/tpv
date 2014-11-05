package dao;

import java.util.Collection;

import entity.base.EntityBase;

import transaccion.Transaction;

public interface GenericDAO {

	public int save(EntityBase entidad)  throws Exception;
	public boolean delete(EntityBase entidad)  throws Exception;
	public boolean update(EntityBase entidad)  throws Exception;
	public EntityBase find(EntityBase entidad)  throws Exception;
	public Collection<EntityBase> select(EntityBase entidad)  throws Exception;
	public int size()  throws Exception;
//	public Transaction Transaction(Transaction t)throws Exception;
}
