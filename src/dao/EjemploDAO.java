package dao;

import vo.EjemploVO;
import entity.Ejemplo;


public class EjemploDAO<T extends EjemploVO> extends AbstractDAO{

	public EjemploDAO(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	super(key);
	}

	public int save(T vo) throws Exception {
		Ejemplo ej= new Ejemplo();
		ej.setId(vo.getId());
		ej.setNombre(vo.getNombre());
		ej.setApellido(vo.getApellido());
		db.getSesion().save(ej);
		return 1;
	}
	
}
