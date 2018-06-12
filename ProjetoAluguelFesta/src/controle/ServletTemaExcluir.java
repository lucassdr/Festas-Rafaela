package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

@WebServlet("/excluir")
public class ServletTemaExcluir extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletTemaExcluir() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codigoStr = request.getParameter("id");
		Integer codigo = Integer.parseInt(codigoStr);

		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();
		
		
		// carregar o temauto escolhido do banco
		Tema tema = dao.obter(codigo);
		
		
		// excluir o temauto do banco de dados
		dao.excluir(tema);

		// fazer redirect para listar os temautos, a fim de evitar
		// vários envios repetidos
		response.sendRedirect("listarTemasAtivos");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
