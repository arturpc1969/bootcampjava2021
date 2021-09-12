package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livraria.dominio.Autor;

public class AutorDao {

	private Connection conexao;

	public AutorDao(Connection conexao) {
		this.conexao = conexao;
	}

	public void cadastrar(Autor autor) {
		try {
			String sql = "insert into autores (nome, email, data_nascimento, mini_curriculo) values (?, ?, ?, ?)";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDataDeNascimento()));
			ps.setString(4, autor.getMiniCurriculo());

			ps.execute();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public List<Autor> listar() {

		String url = "jdbc:mysql://localhost:3306/livraria";
		String usuario = "root";
		String senha = "mysqlpassword";

		try {
			Connection conexao = DriverManager.getConnection(url, usuario, senha);
			String sql = "select * from autores order by id desc";

			PreparedStatement ps = conexao.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			List<Autor> autores = new ArrayList<Autor>();

			while (rs.next()) {

				Autor autor = new Autor();
				autor.setNome(rs.getString("nome"));
				autor.setEmail(rs.getString("email"));
				autor.setDataDeNascimento(rs.getDate("data_nascimento").toLocalDate());
				autor.setMiniCurriculo(rs.getString("mini_curriculo"));

				autores.add(autor);
			}
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
