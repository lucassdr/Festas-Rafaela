package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ItemDAO;
import modelo.dominio.Item;

@WebServlet("/excluirItem")
public class ServletItemExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletItemExcluir() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoStr = request.getParameter("id");
		Integer id = Integer.parseInt(codigoStr);

		// criar instância do DAO para persistência
		ItemDAO dao = new ItemDAO();

		// carregar o temauto escolhido do banco
		Item item = dao.obter(id);

		// excluir o temauto do banco de dados
		dao.excluir(item);

		// fazer redirect para listar os temautos, a fim de evitar
		// vários envios repetidos
		response.sendRedirect("listarItensAtivos");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
