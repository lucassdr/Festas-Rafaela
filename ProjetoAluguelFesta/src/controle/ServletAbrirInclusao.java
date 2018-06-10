package controle;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.dominio.Tema;


@WebServlet("/abrirInclusao")
public class ServletAbrirInclusao extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletAbrirInclusao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// criar um novo objeto vazio
		Tema prod = new Tema();
		
		// guardar o novo Tema no request para ser lido pela página
		request.setAttribute("prod", prod);
	
		
		// enviar o processamento para a pagina
		RequestDispatcher desp = request.getRequestDispatcher("temaEditar.jsp");
		desp.forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
