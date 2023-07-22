package pe.caja.test.servicio;

import java.sql.SQLException;
import java.util.List;

import pe.caja.test.bean.PersonaBean;
import pe.caja.test.dao.PersonaDao;

public class PersonaServicio {
	public void insertarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {

		PersonaDao personaDao = new PersonaDao();
		personaDao.insertarPersona(persona);
		
		

	}
	
	public PersonaBean buscarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {
		
		PersonaDao personadao=new PersonaDao();
		PersonaBean personaRespuesta=personadao.buscarPersona(persona);
		return personaRespuesta;
		
	}
	public List<PersonaBean> buscarPersonaSexo(PersonaBean persona) throws ClassNotFoundException, SQLException {
		
		PersonaDao personadao=new PersonaDao();
		List<PersonaBean> personaRespuesta=personadao.buscarPersonaSexo(persona);
		return personaRespuesta;
		
	}
	
	public void eliminarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {

		PersonaDao personaDao = new PersonaDao();
		personaDao.eliminarPersona(persona);
		
		

	}
	
	
}
