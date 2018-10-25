package br.com.unialfa.nupes.entity;

public class Pessoa extends Curso {

	int id;
	int matricula;
	String nome;

	public Pessoa() {
	}

	public Pessoa(int id, int matricula, String nome) {
		this.id = id;
		this.matricula = matricula;
		this.nome = nome;

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getMatricula() {
		return matricula;
	}

	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
