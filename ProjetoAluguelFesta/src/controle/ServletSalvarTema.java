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

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

@WebServlet("/salvarTema")
public class ServletSalvarTema extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public ServletSalvarTema() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendError(403, "Acesso proibido para método GET. Use o formulário para enviar.");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<String> erros = new ArrayList<String>();
		
		// ler os campos do formulário
		String codigoStr = request.getParameter("codigo");
		String valorStr = request.getParameter("valor");
		String corDaToalha = request.getParameter("corDaToalha");
		String nome = request.getParameter("nome");
		
		// converter os tipos numéricos

		Integer codigo;
		try {
			codigo = Integer.parseInt(codigoStr);
		} catch (NumberFormatException e) {
			codigo = null;
		}
		
		Float valor;
		try {
			valor = Float.parseFloat(valorStr);
		} catch (NumberFormatException e) {
			valor = null;
		}
		
		if(valor == null)
			erros.add("O campo Valor é obritatório");
		
		if (corDaToalha == null || corDaToalha.trim().length() == 0)
			erros.add("O campo Descrição é obrigatório.");
		
		if (corDaToalha == null)
			erros.add("O valor digitado no campo Cor da tolha é inválido.");
		
		if (nome == null)
			erros.add("O valor digitado no campo Nome é inválido.");
		
		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();
		// transferir os dados para o objeto do Modelo
		Tema tema;
		
		if (codigo == null)
			tema = new Tema();
		else
			tema = dao.obter(codigo);
		
		// alterar os dados do objeto
		tema.setCodigo(codigo);
		tema.setValor(valor);
		tema.setCorDaToalha(corDaToalha);
		tema.setNome(nome);
		
		// testar se os dados enviados estão corretos
		if (erros.size() == 0)
		{
			// salvar o objeto no banco de dados
			tema = dao.salvar(tema);

			// fazer redirect para listar os temautos, a fim de evitar
			// vários envios repetidos
			response.sendRedirect("listarTemas");
		}
		else
		{
			// guardar o temauto no request para ser lido pela página
			request.setAttribute("tema", tema);
			request.setAttribute("erros", erros);
	
			// criar um objeto para despachar a requisição
			RequestDispatcher desp = request.getRequestDispatcher("temaEditar.jsp");
			// encaminhar para o servlet ou página selecionada
			desp.forward(request, response);
		}
		
	}

}
