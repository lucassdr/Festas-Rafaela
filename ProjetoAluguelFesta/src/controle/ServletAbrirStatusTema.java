package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/statusTema")
public class ServletAbrirStatusTema extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAbrirStatusTema() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// ler os campos do formulário
		String idStr = request.getParameter("id");
		String status = request.getParameter("status");

		// converter os tipos numéricos

		Integer id;
		try {
			id = Integer.parseInt(idStr);
		} catch (NumberFormatException e) {
			id = null;
		}

	
		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();
		// transferir os dados para o objeto do Modelo
		Tema tema;

		if (id == null)
			tema = new Tema();
		else
			tema = dao.obter(id);

		// alterar os dados do objeto
		tema.setId(id);
		tema.setStatus(status);

		if (tema.getStatus().equals("ativo")) {
			tema.setStatus("inativo");
			tema = dao.salvar(tema);
			response.sendRedirect("listarTemasAtivos");
		} else if (tema.getStatus().equals("inativo")) {
			tema.setStatus("ativo");
			tema = dao.salvar(tema);
			response.sendRedirect("listarTemasInativos");
		}

	}

}
