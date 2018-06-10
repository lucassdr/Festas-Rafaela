package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dao.TemaDAO;
import modelo.dominio.Tema;

/**
 * Servlet implementation class ServletStatusTema
 */
@WebServlet("/ServletStatusTema")
public class ServletStatusTema extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletStatusTema() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String codigoStr = request.getParameter("codigo");
		Integer codigo = Integer.parseInt(codigoStr);
		
		// criar instância do DAO para persistência
		TemaDAO dao = new TemaDAO();

		// carregar o Tema escolhido do banco
		Tema tem = dao.obter(codigo);	
		
		// guardar o Tema no request para ser lido pela página
		request.setAttribute("tem", tem);
		

		
		// criar um objeto para despachar a requisição
		RequestDispatcher desp = request.getRequestDispatcher("temaEditar.jsp");
		// encaminhar para o servlet ou página selecionada
		desp.forward(request, response);
	}

}
