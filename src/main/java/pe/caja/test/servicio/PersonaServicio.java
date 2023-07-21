package pe.caja.test.servicio;

import java.sql.SQLException;

import pe.caja.bean.PersonaBean;
import pe.caja.consultas.PersonaConsulta;

public class PersonaServicio {
	public void insertarPersona(PersonaBean persona) throws ClassNotFoundException, SQLException {

		PersonaConsulta personaconsuta = new PersonaConsulta();
		personaconsuta.insertarPersona(persona);

	}
}
