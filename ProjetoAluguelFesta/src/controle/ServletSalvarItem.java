package controle;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/salvarItem")
public class ServletSalvarItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletSalvarItem() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendError(403, "Acesso proibido para método GET. Use o formulário para enviar.");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> erros = new ArrayList<String>();
		
		// ler os campos do formulário
		String codigoStr = request.getParameter("id");		
		String nome = request.getParameter("nome");
		String temaStr = request.getParameter("tema");
		
		// converter os tipos numéricos

		Integer id;
		try {
			id = Integer.parseInt(codigoStr);
		} catch (NumberFormatException e) {
			id = null;
		}
		
		Integer idTema;
		Tema tema;
		try {
			idTema = Integer.parseInt(temaStr);
			
			// ler a categoria escolhida do banco
			TemaDAO daoTem = new TemaDAO();
			tema = daoTem.obter(idTema);
		} catch (NumberFormatException e) {
			idTema = null;
			tema = null;
		}
		
		
		if (nome == null)
			erros.add("O valor digitado no campo Nome é inválido.");
		
		/*if (tema == null)
			erros.add("O valor digitado no campo Situação é inválido.");*/
		
		// criar instância do DAO para persistência
		ItemDAO dao = new ItemDAO();
		// transferir os dados para o objeto do Modelo
		Item item;
		
		if (id == null)
			item = new Item();
		else
			item = dao.obter(id);
		
		// alterar os dados do objeto
		item.setId(id);
		item.setNome(nome);
		item.setTema(tema);
		
		// testar se os dados enviados estão corretos
		if (erros.size() == 0)
		{
			// salvar o objeto no banco de dados
			item.setStatus("ativo");
			item = dao.salvar(item);

			// fazer redirect para listar os temautos, a fim de evitar
			// vários envios repetidos
			response.sendRedirect("listarItensAtivos");
		}
		else
		{
			// guardar o temauto no request para ser lido pela página
			request.setAttribute("tema", tema);
			request.setAttribute("erros", erros);
			
			// ler a lista de categorias
			ItemDAO daoIt = new ItemDAO();
			List<Item> listaTem = daoIt.listar();
			// guardar a lista de categorias no request
			request.setAttribute("listaTem", listaTem);
	
			// criar um objeto para despachar a requisição
			RequestDispatcher desp = request.getRequestDispatcher("itemEditar.jsp");
			// encaminhar para o servlet ou página selecionada
			desp.forward(request, response);
		}
		
	}

}
