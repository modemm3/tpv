package conexion;

public abstract class DBManager {
	
	public abstract <T> DB<T> factoryMethod(Class<?> c) throws ClassNotFoundException,InstantiationException,IllegalAccessException;
}
