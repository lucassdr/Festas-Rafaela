package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.digest.DigestUtils;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@WebServlet("/login")
public class ServletLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String username = request.getParameter("username");
		String password = request.getParameter("pass");

		UsuarioDAO dao = new UsuarioDAO();

		List<Usuario> usuarios = dao.listar();

		request.setAttribute(username, password);

		boolean seguir = false;

		for (Usuario user : usuarios) {
			if (user.getNomeUsuario().equals(username)) {
				password = DigestUtils.sha256Hex(password);
				if (user.getSenha().equals(password)) {
					seguir = true;
				}
			}
		}

		if (!seguir) {
			response.sendRedirect("login.jsp");
		} else {
			HttpSession session = request.getSession();
			session.setAttribute("username", username);
			session.setAttribute("password", password);
			response.sendRedirect("index.jsp");
		}

	}
}
