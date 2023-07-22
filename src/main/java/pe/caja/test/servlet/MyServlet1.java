package pe.caja.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import pe.caja.test.bean.PersonaBean;
import pe.caja.test.servicio.PersonaServicio;

@WebServlet("/login")
public class MyServlet1 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PersonaBean personabean=new PersonaBean();
		
		
		try{
			response.setContentType("text/html");
			PrintWriter pwriter = response.getWriter();
			String personID = request.getParameter("personID");
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			String city = request.getParameter("city");
			String sexo=request.getParameter("sexo");
			
			personabean.setFirstName(firstName);
			personabean.setLastName(lastName);
			personabean.setPersonID(Integer.valueOf(personID));
			personabean.setAddress(address);
			personabean.setCity(city);
			personabean.setSexo(sexo);
			
			
			
			PersonaServicio personaservicio=new PersonaServicio();
			System.out.println(sexo);
		    personaservicio.insertarPersona(personabean);
			
			pwriter.print("Hola:"+personabean.getFirstName());
			pwriter.print(" Tu apellido es: "+personabean.getLastName());
			//Creating two cookies
			Cookie c1=new Cookie("userName",firstName);
			Cookie c2=new Cookie("userPassword",lastName);
			//Adding the cookies to response header
			response.addCookie(c1);
			response.addCookie(c2);
			pwriter.print("<a href='welcomehere'>View Details</a>");
			pwriter.close();
			}catch(Exception exp){
			System.out.println(exp);
			}
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		PersonaBean personabean=new PersonaBean();
		PrintWriter pwriter = response.getWriter();
		String personID = request.getParameter("codigoId");
		personabean.setPersonID(Integer.valueOf(personID));
		
		PersonaServicio personaservicio=new PersonaServicio();
		try {
			personaservicio.eliminarPersona(personabean);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	}
	
	
	
	
	


