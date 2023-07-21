package pe.caja.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.caja.bean.PersonaBean;
import pe.caja.jdbc.ConexionMysql;

public class PersonaDao {
	private String sql="SELECT * FROM Persons";
	private String sqlInsert="insert into Persons (personID, lastName, firstName, address, city) values (?, ?, ?, ?, ?)";
	
	public List<PersonaBean> listadoPersona() throws SQLException, ClassNotFoundException{
		
		List<PersonaBean> listado = new ArrayList<PersonaBean>();
		System.out.println("Creating statement...");
		
		
		ConexionMysql conexion=new ConexionMysql();
		Connection conn=conexion.obtenerConexion();
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery(sql);
		
		while(rs.next()) {
			PersonaBean personabean=new PersonaBean();		
			
			//Retrieve by column name
			int personID  = rs.getInt("personID");
			String lastName = rs.getString("lastName");
			String firstName = rs.getString("firstName");
			String address = rs.getString("address");
			String city = rs.getString("city");
			personabean.setPersonID(personID);
			personabean.setLastName(lastName);
			personabean.setFirstName(firstName);
			personabean.setAddress(address);
			personabean.setCity(city);
			
		listado.add(personabean);
			
		}
		
		return listado;
		
	}
	
	public void insertarPersona(PersonaBean persona) throws SQLException, ClassNotFoundException {
		ConexionMysql conexion=new ConexionMysql();
		Connection conn=conexion.obtenerConexion();
		Statement stmt = conn.createStatement();
		PreparedStatement preparedStmt = conn.prepareStatement(sqlInsert);
		preparedStmt.setInt(1, persona.getPersonID());
		preparedStmt.setString(2, persona.getLastName());
		preparedStmt.setString(3, persona.getFirstName());
		preparedStmt.setString(4, persona.getAddress());
		preparedStmt.setString(5, persona.getCity());
		
		preparedStmt.execute();
		conn.close();
		
		
	}
	
	

}
