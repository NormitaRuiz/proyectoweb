package pe.caja.test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pe.caja.test.bean.PersonaBean;
import pe.caja.test.jdbc.ConexionMysql;

public class PersonaDao {
	private String sql="SELECT * FROM Persons";
	private String sqlInsert="insert into Persons (personID, lastName, firstName, address, city, sexo) values (?, ?, ?, ?, ?, ?)";
	private String sqlBuscar="SELECT * FROM Persons where personID=?";
	private String sqlBuscarSexo="SELECT * FROM Persons where sexo=?";
	private String sqlEliminar="DELETE FROM Persons where personID=?";
	
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
			String sexo = rs.getString("sexo");
			personabean.setPersonID(personID);
			personabean.setLastName(lastName);
			personabean.setFirstName(firstName);
			personabean.setAddress(address);
			personabean.setCity(city);
			personabean.setSexo(sexo);
			
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
		preparedStmt.setString(6, persona.getSexo());
		
		preparedStmt.execute();
		conn.close();
		
		
	}
	
	///creando el metodo buscar persona
	public PersonaBean buscarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {
	//creando el objeto	
		ConexionMysql conexionBuscar=new ConexionMysql();
		Connection conexBuscar=conexionBuscar.obtenerConexion();//establecer la conexion al mysql
		Statement stmtBuscar=conexBuscar.createStatement();//sirve para preparar la ejecucion al mysql
		
		
		//preparando l sentencia con sus varibles, tenemos una sola interrogante
		PreparedStatement preparedStmt = conexBuscar.prepareStatement(sqlBuscar);
		preparedStmt.setInt(1, persona.getPersonID());
		//ejecutando la sentencia
		ResultSet resultadoBuscar = preparedStmt.executeQuery();
		
		PersonaBean personabeanbuscar=new PersonaBean();
		
		while(resultadoBuscar.next()) {
			
			
			//sacando de la tabla la informacion
			
			int personID=resultadoBuscar.getInt("personID");
			//guardo en el objeto personabeanbuscar
			personabeanbuscar.setPersonID(personID);
			String lastName = resultadoBuscar.getString("lastName");
			String firstName = resultadoBuscar.getString("firstName");
			String address = resultadoBuscar.getString("address");
			String city = resultadoBuscar.getString("city");
			String sexo = resultadoBuscar.getString("sexo");
			personabeanbuscar.setLastName(lastName);
			personabeanbuscar.setFirstName(firstName);
			personabeanbuscar.setAddress(address);
			personabeanbuscar.setCity(city);
			personabeanbuscar.setSexo(sexo);
			
			
			
		}
		
		return personabeanbuscar;
		
	}
	
	///creando el metodo buscar persona
		public List<PersonaBean> buscarPersonaSexo(PersonaBean persona) throws ClassNotFoundException, SQLException {
			
			List<PersonaBean> listado=new ArrayList<PersonaBean>();
		//creando el objeto	
			ConexionMysql buscarPersonaSexo=new ConexionMysql();
			Connection conn=buscarPersonaSexo.obtenerConexion();//establecer la conexion al mysql
			Statement stmtBuscarsexo=conn.createStatement();//sirve para preparar la ejecucion al mysql
			
			
			//preparando l sentencia con sus varibles, tenemos una sola interrogante
			PreparedStatement preparedStmt = conn.prepareStatement(sqlBuscarSexo);
			preparedStmt.setString(1, persona.getSexo());
			//ejecutando la sentencia
			ResultSet resultadoBuscar = preparedStmt.executeQuery();
			
			
			
			while(resultadoBuscar.next()) {
				
				PersonaBean personabeanbuscarsexo=new PersonaBean();
				//sacando de la tabla la informacion
				
				int personID=resultadoBuscar.getInt("personID");
				//guardo en el objeto personabeanbuscar
				personabeanbuscarsexo.setPersonID(personID);
				String lastName = resultadoBuscar.getString("lastName");
				String firstName = resultadoBuscar.getString("firstName");
				String address = resultadoBuscar.getString("address");
				String city = resultadoBuscar.getString("city");
				String sexo = resultadoBuscar.getString("sexo");
				personabeanbuscarsexo.setLastName(lastName);
				personabeanbuscarsexo.setFirstName(firstName);
				personabeanbuscarsexo.setAddress(address);
				personabeanbuscarsexo.setCity(city);
				personabeanbuscarsexo.setSexo(sexo);
				
				listado.add(personabeanbuscarsexo);
				
				
			}
			return listado;
		

}
		
		public void eliminarPersona(PersonaBean persona) throws SQLException, ClassNotFoundException {
			ConexionMysql conexion=new ConexionMysql();
			Connection conn=conexion.obtenerConexion();
			Statement stmt = conn.createStatement();
			PreparedStatement preparedStmt = conn.prepareStatement(sqlEliminar);
			preparedStmt.setInt(1, persona.getPersonID());
			
			preparedStmt.execute();
			conn.close();
			
			
		}
		
		
}
