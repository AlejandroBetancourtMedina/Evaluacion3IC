package controlador;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.LoginDao;

@WebServlet(name="ValidadorServlet", urlPatterns= {"/ValidadorServlet"})
public class ValidadorServlet extends HttpServlet{
	
	private static final long serialVersionUID =1L;
	
	protected void processRequest(HttpServletRequest request, HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()) {
			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Validador</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Validador at "+ request.getContextPath() +"</h1>");
			out.println("</body>");
			out.println("</html>");
			
			
		}
		
	}
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		processRequest(request, response);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException,IOException{
		response.setContentType("text/html;charset=UTF-8");
		
		String usuario, password, msg="";
		
		//recibir parametro
		usuario=request.getParameter("usuario");
		password=request.getParameter("password");
		
		//validacion de los datos
		try {
			if(LoginDao.validar(usuario,password)>0) {
				msg = "Usuario y Contraseña Correctos";
			}else {
				msg="Error de acceso";
			}
		} catch (Exception e ) {
			e.printStackTrace();
		}
		
		
		//proxima vista
		RequestDispatcher despachador = request.getRequestDispatcher("/mensaje.jsp");
		
		//preparacion de datos de la vista
		request.setAttribute("mensaje", msg);
		
		//Despachador
		despachador.forward(request, response);
	}

	
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
