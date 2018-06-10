package controle;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.ItemDAO;
import modelo.dominio.Item;

/**
 * Servlet implementation class ServletAbrirAlteracao
 */
@WebServlet("/statusItem")
public class ServletAbrirStatusItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAbrirStatusItem() {
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

		/*
		 * if (tema == null)
		 * erros.add("O valor digitado no campo Situação é inválido.");
		 */

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
		item.setStatus(status);

		if (item.getStatus().equals("ativo")) {
			item.setStatus("inativo");
			item = dao.salvar(item);
			response.sendRedirect("listarItensAtivos");
		} else if (item.getStatus().equals("inativo")) {
			item.setStatus("ativo");
			item = dao.salvar(item);
			response.sendRedirect("listarItensInativos");
		}

	}

}
