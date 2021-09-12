package br.com.alura.livraria.factory;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	
	public Connection getConnection () {
		try {
			String url = "jdbc:mysql://localhost:3306/livraria?useSSL=false&serverTimeZone=UTC";
			String usuario = "root";
			String senha = "mysqlpassword";
			
			Class.forName("com.mysql.cj.jdbc.Driver"); //Esse código é necessário para que o driver do MySQL seja carregado pela servlet

			Connection conexao = DriverManager.getConnection(url, usuario, senha);			
			return conexao;
		} catch (Exception e) {
			throw new RuntimeException();
		}
	
	}

}
