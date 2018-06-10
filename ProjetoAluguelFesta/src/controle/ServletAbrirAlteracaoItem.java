package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ItemDAO;
import modelo.dao.TemaDAO;
import modelo.dominio.Item;
import modelo.dominio.Tema;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/editarItem")
public class ServletAbrirAlteracaoItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAbrirAlteracaoItem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String idStr = request.getParameter("id");
		Integer id = Integer.parseInt(idStr);
		
		// criar instância do DAO para persistência
		ItemDAO dao = new ItemDAO();

		// carregar o Tema escolhido do banco
		Item it = dao.obter(id);
		
		// guardar o Tema no request para ser lido pela página
		request.setAttribute("it", it);
		
		// ler a lista de categorias
		TemaDAO daoTem = new TemaDAO();
		List<Tema> listaTem = daoTem.listar();
		// guardar a lista de categorias no request
		request.setAttribute("listaTem", listaTem);
		
		
		// criar um objeto para despachar a requisição
		RequestDispatcher desp = request.getRequestDispatcher("itemEditar.jsp");
		// encaminhar para o servlet ou página selecionada
		desp.forward(request, response);
	}


}
