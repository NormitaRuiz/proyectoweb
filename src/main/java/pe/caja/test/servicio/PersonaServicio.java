package pe.caja.test.servicio;

import java.sql.SQLException;

import pe.caja.test.bean.PersonaBean;
import pe.caja.test.dao.PersonaDao;

public class PersonaServicio {
	public void insertarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {

		PersonaDao personaDao = new PersonaDao();
		personaDao.insertarPersona(persona);

	}
}
