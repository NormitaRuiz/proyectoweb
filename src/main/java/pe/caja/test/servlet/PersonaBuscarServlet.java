package pe.caja.test.servlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.caja.test.bean.PersonaBean;
import pe.caja.test.servicio.PersonaServicio;

@WebServlet("/buscar")
public class PersonaBuscarServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		//este objeto se crea para poder enviar ee objeto a otras clases y poder manipular esa data
		PersonaBean personabean=new PersonaBean();
		String personID = req.getParameter("codigoId");
		
		personabean.setPersonID(Integer.valueOf(personID));
		
		PersonaServicio personaservicio=new PersonaServicio();
		///sirve para controlar errores
		 try {
			PersonaBean persona = personaservicio.buscarPersona(personabean);
			
			System.out.println(persona.getPersonID());
			System.out.println(persona.getLastName());
			System.out.println(persona.getFirstName());
			System.out.println(persona.getAddress());
			System.out.println(persona.getCity());
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(personID);
		
	}

	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		PersonaBean personabean=new PersonaBean();
		String sexo = req.getParameter("sexo");
		personabean.setSexo(sexo);
		
		PersonaServicio personaservicio=new PersonaServicio();
		///sirve para controlar errores
		 try {
			 List<PersonaBean> persona = personaservicio.buscarPersonaSexo(personabean);
			
			for (PersonaBean personaBean2 : persona) {
				
				System.out.println(personaBean2.getPersonID());
				System.out.println(personaBean2.getLastName());
				System.out.println(personaBean2.getFirstName());
				System.out.println(personaBean2.getAddress());
				System.out.println(personaBean2.getCity());
				System.out.println(personaBean2.getSexo());
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(sexo);
		
	}
	
	
		
	}
	
	


