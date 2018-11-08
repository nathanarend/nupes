package br.com.unialfa.nupes.entity;

public class Pessoa extends Curso {

	String matricula;
	String nome;
	int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Pessoa() {
	}

	public Pessoa(String matricula, String nome) {

		this.matricula = matricula;
		this.nome = nome;

	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
