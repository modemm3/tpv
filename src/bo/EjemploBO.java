package bo;

import transaccion.Transaction;
import transaccion.TransactionImpl;
import vo.EjemploVO;
import Test.TestConexionMUltiple;
import dao.EjemploDAO;
import dao.GenericOperactionsDAO;
import entity.Ejemplo;

public class EjemploBO implements Transaction {

	TransactionImpl tx;
	EjemploDAO<EjemploVO> dao;
	public EjemploBO() {
		super();
		try {
			TestConexionMUltiple.main(new String[]{});
			tx = new TransactionImpl("uno");
			tx.launchTransaccion(this);
			dao= new EjemploDAO<EjemploVO>("uno");
			EjemploVO ej= new EjemploVO();
			ej.setId(5);
			dao.save(ej);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public <T> Transaction transaction(GenericOperactionsDAO t) throws Exception {
		Ejemplo e= new Ejemplo();
		e.setId(10);
		e.setNombre("modesto mejia");
		e.setApellido("martinez");
		t.save(e);
		e= new Ejemplo();
		e.setId(9);
		e.setNombre("modesto mejia");
		e.setApellido("martinez");
		t.save(e);
		return this;
	}

	public static void main(String[] args) {
		EjemploBO e= new EjemploBO();
	}

}
