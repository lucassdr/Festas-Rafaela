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
import modelo.dominio.Item;
import modelo.dominio.Tema;


@WebServlet("/abrirInclusaoItem")
public class ServletAbrirInclusaoItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAbrirInclusaoItem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// criar um novo objeto vazio
		Item it = new Item();
		
		// guardar o novo Item no request para ser lido pela página
		request.setAttribute("it", it);
		
		// ler a lista de categorias
		TemaDAO daoTem = new TemaDAO();
		List<Tema> listaTem = daoTem.listar();
		// guardar a lista de categorias no request
		request.setAttribute("listaTem", listaTem);
	
		
		// enviar o processamento para a pagina
		RequestDispatcher desp = request.getRequestDispatcher("itemEditar.jsp");
		desp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
