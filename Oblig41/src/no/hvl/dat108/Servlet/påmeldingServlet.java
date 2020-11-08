package no.hvl.dat108.Servlet;

import static no.hvl.dat108.UrlMappings.*;

import java.io.IOException;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;

import no.hvl.dat108.Passord;

@WebServlet("/paameldingskjema")
public class påmeldingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//doGet må ordnes med feilmeldinger her
		/*
		String ffornavn = "";
		String fetternavn = "";
		String fmobilnummer = "";
		String fkjonn = "";
		if (request.getParameter("fornavn") != null) {
			ffornavn = "Ugyldig fornavn";
		}
		if (request.getParameter("etternavn") != null) {
			fetternavn = "Ugyldig etternavn";
		}
		if (request.getParameter("mobilnummer") != null) {
			fmobilnummer = "Ugyldig mobilnummer";
		}
		if (request.getParameter("kjonn") != null) {
			fkjonn = "Du må oppgi kjonn";
		}
		request.setAttribute("ffornavn", ffornavn);
		request.setAttribute("fetternavn", fetternavn);
		request.setAttribute("fmobilnummer", fmobilnummer);
		request.setAttribute("fkjonn", fkjonn);
		*/

		request.getRequestDispatcher("WEB-INF/paameldingskjema.jsp").forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		boolean bool;

		try { //Denne Try catch er qucikfix, bør gjøre det kun med parseInten
			
			String fornavn = request.getParameter("fornavn");
			String etternavn = request.getParameter("etternavn");
			String mobilnummerString = request.getParameter("mobil");
			int mobilnummer = Integer.parseInt(mobilnummerString);
			String nyttPassord = request.getParameter("passord");
			String kjonn = request.getParameter("kjonn");
			Passord passord = Passord.lagPassord(nyttPassord);
			Deltager ny = new Deltager(fornavn, etternavn, mobilnummer, kjonn, passord);

			if (deltagerDAO.hentDeltager(mobilnummer) == null) {
				deltagerDAO.lagreNyDeltager(ny);

				request.setAttribute("fornavn", fornavn);
				request.setAttribute("etternavn", etternavn);
				request.setAttribute("mobilnummer", mobilnummer);
				request.setAttribute("kjonn", kjonn);
				
				bool = true;

				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
					sesjon.invalidate();
				}
				sesjon = request.getSession(true);
				sesjon.setMaxInactiveInterval(60);
				sesjon.setAttribute("bool", bool);

				request.getRequestDispatcher(CONFIRM_URL).forward(request, response);
			} else {
				response.sendRedirect(LOGIN_URL);
			}
		} catch (NumberFormatException e) {
			request.getRequestDispatcher("WEB-INF/paameldingskjema.jsp").forward(request, response);
		}
	}
}

