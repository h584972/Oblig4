package no.hvl.dat108.Servlet;

import static no.hvl.dat108.UrlMappings.LOGIN_URL;
import java.io.IOException;

import javax.ejb.EJB;
import javax.faces.validator.Validator;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import no.hvl.dat108.Deltager;
import no.hvl.dat108.DeltagerDAO;
import no.hvl.dat108.Passordhjelper;

@WebServlet("/" + LOGIN_URL)
public class logginnServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@EJB
	private DeltagerDAO deltagerDAO;
	private Passordhjelper PH;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String loginMessage = "";

		if (request.getParameter("requiresLogin") != null) {
			loginMessage = "Forespørselen din krever pålogging. " + "(Du kan ha blitt logget ut automatisk)";

		} else if (request.getParameter("invalidUsername") != null) {
			loginMessage = "Ugyldig brukernavn eller passord";
		}

		request.setAttribute("loginMessage", loginMessage);

		request.getRequestDispatcher("WEB-INF/logginn.jsp").forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String mobil = request.getParameter("mobil");
		String passord = request.getParameter("passord");
		Boolean bool;

		try {

			Deltager d = deltagerDAO.hentDeltager(Integer.parseInt(mobil));
			//if (mobil == null || !Validator.isValidUsername(mobil)) {
	         //   response.sendRedirect(LOGIN_URL + "?invalidUsername");
	        //}

			if (PH.validerMedSalt2(passord, d.getPassord().getSalt(), d.getPassord().getHash())) {

				bool = true;

				HttpSession sesjon = request.getSession(false);
				if (sesjon != null) {
					sesjon.invalidate();
				}
				sesjon = request.getSession(true);
				sesjon.setMaxInactiveInterval(60);
				sesjon.setAttribute("bool", bool);

				response.sendRedirect("deltagerliste");
			}

		} catch (NullPointerException | IllegalArgumentException e) {
			response.sendRedirect(LOGIN_URL + "?invalidUsername");
		}

	}
}
