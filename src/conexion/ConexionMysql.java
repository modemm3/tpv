package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.w3c.dom.Document;

public class ConexionMysql implements DB<Connection> {

	private String url;
	private String user;
	private String pwd;
	private Connection conexion;
	public ConexionMysql() throws SQLException {
		super();
		try{
		Class.forName("org.gjt.mm.mysql.Driver");
		}
		catch(Exception ex){
			
		}
		url="jdbc:mysql://localhost:3306/abarrotestpv";
		user="root";
		pwd="12345";
		conexion=DriverManager.getConnection(url,user,pwd);
	}

	@Override
	public Connection getSesion() throws Exception{
			return conexion;
	}

	@Override
	public void closeSession() throws Exception {
		
		if(!conexion.isClosed()){
			conexion.close();
			conexion=null;
		}
	}

	@Override
	public Connection currentSession() {
		return conexion;
	}

	@Override
	public void setKey(String key) {
		// TODO Auto-generated method stub
		
	}




}
