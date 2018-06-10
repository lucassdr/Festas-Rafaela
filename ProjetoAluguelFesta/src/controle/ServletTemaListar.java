package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

@WebServlet("/listarTemas")
public class ServletTemaListar extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletTemaListar() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();
		
		// carregar do banco a lista de produtos...
		List<Tema> lista = dao.listar();
		
		// enviar a lista de produtos para a página...
		request.setAttribute("lista", lista);
		
		// enviar o processamento para a página
		RequestDispatcher desp = request.getRequestDispatcher("temaListar.jsp");
		desp.forward(request, response);
	}



}
