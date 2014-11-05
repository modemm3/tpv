package conexion;


public interface DB<T> {

	
	public T getSesion() throws Exception;
	public void closeSession() throws Exception;
	public T currentSession();
	public void setKey(String key);
//	public void addConfigFile(org.w3c.dom.Document documento, String key);
}
