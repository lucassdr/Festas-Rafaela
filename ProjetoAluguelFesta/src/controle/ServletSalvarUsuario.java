package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.digest.DigestUtils;

import modelo.dao.UsuarioDAO;
import modelo.dominio.Usuario;

@WebServlet("/salvarUsuario")
public class ServletSalvarUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletSalvarUsuario() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.sendError(403, "Acesso proibido para m�todo GET. Use o formul�ririo para enviar.");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String idUsuarioStr = request.getParameter("idUsuario");
		String nomeUsuario = request.getParameter("nomeUsuario");
		String senha = request.getParameter("senha");
		String nome = request.getParameter("nome");
		String sobrenome = request.getParameter("sobrenome");
		String cpf = request.getParameter("cpf");
		String pass = request.getParameter("pass");
		
		if (pass.equalsIgnoreCase("FESTAS123")) {
			Integer idUsuario;
			try {
				idUsuario = Integer.parseInt(idUsuarioStr);
			} catch (NumberFormatException e) {
				idUsuario = null;
			}
			Usuario usuario = new Usuario(idUsuario, nomeUsuario, senha, nome, sobrenome, cpf);
			usuario.setSenha(DigestUtils.sha256Hex(usuario.getSenha()));
			UsuarioDAO dao = new UsuarioDAO();
			dao.salvar(usuario);
			response.sendRedirect("login.jsp");
		} else {
			response.sendRedirect("cadastrar.jsp");
		}

	}

}
