package dao;

import vo.EjemploVO;
import entity.Ejemplo;


public class UsuariosDAO<T extends EjemploVO> extends AbstractDAO{

	public UsuariosDAO(String key) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	super(key);
	}

	public int save(T entidad) throws Exception {
		Ejemplo ej= new Ejemplo();
		ej.setId(entidad.getId());
		ej.setNombre(entidad.getNombre());
		ej.setApellido(entidad.getApellido());
		db.getSesion().save(ej);
		return 1;
	}
	
}
