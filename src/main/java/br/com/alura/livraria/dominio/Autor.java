package br.com.alura.livraria.dominio;

import java.time.LocalDate;

public class Autor {
	private String nome;
	private String email;
	private LocalDate dataDeNascimento;
	private String miniCurriculo;
	
	public Autor(String nome, String email, LocalDate dataDeNascimento, String miniCurriculo) {
		super();
		this.nome = nome;
		this.email = email;
		this.dataDeNascimento = dataDeNascimento;
		this.miniCurriculo = miniCurriculo;
	}

	public Autor() {}	

	@Override
	public String toString() {
		return "Autor [nome=" + nome + ", email=" + email + ", dataDeNascimento=" + dataDeNascimento
				+ ", miniCurriculo=" + miniCurriculo + "]";
	}

	public String getNome() {
		return nome;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public String getMiniCurriculo() {
		return miniCurriculo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public void setMiniCurriculo(String miniCurriculo) {
		this.miniCurriculo = miniCurriculo;
	}
	
}


