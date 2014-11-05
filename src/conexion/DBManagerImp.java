package conexion;

/**
 * 
 * @author perita
 *
 *Clase que se encarga de instanciar el tipo de conexion que se va arealizar
 *<li> como puede ser una conexion a una base de datos mysql</li>
 *<li> como puede ser una conexion a una base de datos oracle</li>
 *<li> como puede ser una conexion a una base de datos sql server</li>
 *<li> como puede ser una conexion usando algun ORM(hibernate)</li>
 */
public class DBManagerImp extends DBManager{

	@Override
	public <T>DB<T> factoryMethod(Class<?> c) throws ClassNotFoundException,
			InstantiationException, IllegalAccessException {
		System.out.println(c.getName());
			Object o=Class.forName(c.getName()).newInstance();
			
		return (DB<T>) o;
	}

}
