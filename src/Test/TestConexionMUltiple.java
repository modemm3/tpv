package Test;

import java.sql.Connection;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.hibernate.Session;

import conexion.ConexionHibernateSimple;
import conexion.ConexionMysql;
import conexion.ConnectionHibernateMultiple;
import conexion.DB;
import conexion.DBManager;
import conexion.DBManagerImp;
import conexion.SesionFactory;
import entity.Ejemplo;


public class TestConexionMUltiple {

	public static void main(String[] args) {
		Document documento= DocumentHelper.createDocument();
		documento.addDocType("hibernate-configuration", "-//Hibernate/Hibernate Configuration DTD 3.0//EN", "http://hibernate.sourceforge.net/hibernate-configuration-3.0.dtd");
		Element padre= documento.addElement("hibernate-configuration");
		Element hijo= padre.addElement("session-factory");
		Element nieto2= hijo.addElement("property").addAttribute("name", "hibernate.connection.driver_class");
		nieto2.setText("org.gjt.mm.mysql.Driver");//Driver
		Element nieto3= hijo.addElement("property").addAttribute("name", "hibernate.connection.password");
		nieto3.setText("coramadministrador2008");//password
		Element nieto4= hijo.addElement("property").addAttribute("name", "hibernate.connection.url");
		nieto4.setText("jdbc:mysql://localhost:3306/abarrotestpv?useUnicode=true&amp;characterEncoding=utf8");//url
		Element nieto5= hijo.addElement("property").addAttribute("name", "hibernate.connection.username");
		nieto5.setText("coram");//usuario
		Element nieto6= hijo.addElement("property").addAttribute("name", "hibernate.dialect");
		nieto6.setText("org.hibernate.dialect.MySQL5InnoDBDialect");//lenguaje
		Element nieto8= hijo.addElement("property").addAttribute("name", "hibernate.show_sql");
		nieto8.setText("true");//showSQL
		Element nieto9 = hijo.addElement("property").addAttribute("name", "hibernate.connection.CharSet");
		nieto9.setText("utf8");
		Element nieto10 = hijo.addElement("property").addAttribute("name", "hibernate.connection.characterEncoding");
		nieto10.setText("utf8");
		Element nieto11 = hijo.addElement("property").addAttribute("name", "hibernate.connection.useUnicode");
		nieto11.setText("true");
		hijo.addElement("mapping").addAttribute("resource", "map/Ejemplo.hbm.xml");
		
		
		
		
		DBManager manager= new DBManagerImp();
		DB<Session> db=null;
		try
		{
			org.w3c.dom.Document d=loadXMLFrom(documento.asXML());
//			db=manager.factoryMethod(ConnectionHibernateMultiple.class);
//			db.addConfigFile(d, "uno");
			
			SesionFactory.addConfigFile(d, "uno");
//			db=manager.factoryMethod(ConnectionHibernateMultiple.class);
//			Session s=SesionFactory.getSession("uno");
//			s.beginTransaction();
//			Ejemplo e= new Ejemplo();
//			e.setId(7);
//			e.setNombre("modesto mejia");
//			e.setApellido("martinez");
//			s.save(e);
//			s.getTransaction().commit();
		}

		
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
	public static org.w3c.dom.Document loadXMLFrom(String xml)	throws org.xml.sax.SAXException, java.io.IOException {
		return loadXMLFrom(new java.io.ByteArrayInputStream(xml.getBytes()));
	}

	public static org.w3c.dom.Document loadXMLFrom(java.io.InputStream is)
			throws org.xml.sax.SAXException, java.io.IOException {
		javax.xml.parsers.DocumentBuilderFactory factory = javax.xml.parsers.DocumentBuilderFactory
				.newInstance();
		factory.setNamespaceAware(true);
		factory.setValidating(false);
//		DocumentBuilder db = factory.newDocumentBuilder(); Document doc = db.parse(hbmFile);
		javax.xml.parsers.DocumentBuilder builder = null;
		try {
			factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
			builder = factory.newDocumentBuilder();
		} catch (javax.xml.parsers.ParserConfigurationException ex) {
		}
		org.w3c.dom.Document doc = builder.parse(is);
		is.close();
		return doc;
		
	}
}
