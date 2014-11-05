package dao;

import java.util.Collection;

import transaccion.Transaction;

public interface GenericOperactionsDAO{

	public <T> int save(T entidad)  throws Exception;
	public <T> boolean delete(T entidad)  throws Exception;
	public <T> boolean update(T entidad)  throws Exception;
	public <T> T find(T entidad)  throws Exception;
	public <T> Collection<T> select(T entidad)  throws Exception;
//	public Transaction Transaction(Transaction t)throws Exception;
}
