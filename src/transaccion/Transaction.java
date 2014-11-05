package transaccion;

import dao.GenericDAO;
import dao.GenericOperactionsDAO;



public interface Transaction {

	public <T> Transaction transaction(GenericOperactionsDAO t) throws Exception;
}
