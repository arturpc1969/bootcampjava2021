package br.com.alura.livraria.testes;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

import br.com.alura.livraria.dao.AutorDao;
import br.com.alura.livraria.dominio.Autor;

public class TesteSelectAutor {

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "mysqlpassword";

		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);

			AutorDao dao = new AutorDao(conexao);
			List<Autor> autores = dao.listar();
			autores.forEach(System.out::println);
		} catch (SQLException e) {
			System.out.println("Ocorreu um erro!");
		}

	}

}
