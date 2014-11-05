package Test;

import java.sql.Connection;
import java.sql.PreparedStatement;

import conexion.ConexionMysql;
import conexion.DB;
import conexion.DBManager;
import conexion.DBManagerImp;

public class TestConexion {

	public static void main(String[] args) {
		DBManager manager= new DBManagerImp();
		DB<Connection> db=null;
		try
		{
			db=manager.factoryMethod(ConexionMysql.class);
			Connection con=db.getSesion();
			PreparedStatement p= con.prepareStatement("insert into ejemplo(id,nombre,apellido) values(4,'mode','mejia')");
			p.execute();
			System.out.println("hola");
//			Session s=db.getSesion();
//			s.beginTransaction();
//			Ejemplo e= new Ejemplo();
//			e.setId(2);
//			e.setNombre("modesto mejia");
//			e.setApellido("martinez");
//			s.save(e);
//			s.getTransaction().commit();
		}
		
		
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}
