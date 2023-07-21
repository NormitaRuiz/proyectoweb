package pe.caja.test.bean;

import java.sql.SQLException;
import java.util.List;


import pe.caja.test.dao.PersonaDao;

public class Main {

			
		public static void main(String[] args) throws ClassNotFoundException, SQLException {
			// TODO Auto-generated method stub
			
			PersonaDao personaconsulta=new PersonaDao();
			List<PersonaBean> listadorecepcion=personaconsulta.listadoPersona();
			
			for(int i=0; i<listadorecepcion.size(); i++) {
				PersonaBean person=listadorecepcion.get(i);
				System.out.println("El nombre y la ciudad es: "+person.getFirstName()+person.getCity());
				
			}
			
			System.out.println("*************************************************************************");
			for (PersonaBean personaBean : listadorecepcion) {
				
				System.out.println("El nombre y la ciudad es: "+personaBean.getFirstName()+personaBean.getCity());
			}

		}


	}


