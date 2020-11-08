package no.hvl.dat108.Servlet;

import java.io.IOException;
import java.util.List;
import static no.hvl.dat108.UrlMappings.*;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;

@WebServlet("/deltagerliste")
public class deltagerListeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	@EJB
	DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession sesjon = request.getSession(false);
		
		if (sesjon == null || sesjon.getAttribute("bool") == null || !(boolean) sesjon.getAttribute("bool")) {
			
			response.sendRedirect(LOGIN_URL  + "?requiresLogin");
		}
		

		else {

			List<Deltager> deltagerliste = deltagerDAO.hentAlleDeltagere();

			request.setAttribute("deltagerliste", deltagerliste);

			request.getRequestDispatcher("WEB-INF/deltagerliste.jsp").forward(request, response);
		}
	}

}