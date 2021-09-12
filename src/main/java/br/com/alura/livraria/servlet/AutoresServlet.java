package br.com.alura.livraria.servlet;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.alura.livraria.dao.AutorDao;
import br.com.alura.livraria.dominio.Autor;
import br.com.alura.livraria.factory.ConnectionFactory;

/**
 * Servlet implementation class AutoresServlet
 */
@WebServlet("/autores")
public class AutoresServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private AutorDao dao;

	public AutoresServlet() {
		this.dao = new AutorDao(new ConnectionFactory().getConnection());
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("autores", dao.listar());
		request.getRequestDispatcher("WEB-INF/jsp/autores.jsp").forward(request, response); // O caminho completo para o
																							// arquivo jsp é necessário
																							// aqui.
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		LocalDate dataDeNascimento = LocalDate.parse(request.getParameter("dataDeNascimento"),
				DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		String miniCurriculo = request.getParameter("miniCurriculo");

		Autor autor = new Autor(nome, email, dataDeNascimento, miniCurriculo);
		dao.cadastrar(autor);

		response.sendRedirect("autores");
	}

}
