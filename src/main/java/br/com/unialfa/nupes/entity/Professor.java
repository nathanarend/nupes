package br.com.unialfa.nupes.entity;

public class Professor {

	int id;
	String titulacao;

	public Professor() {

	}

	public Professor(int id, String titulacao) {
		this.id = id;
		this.titulacao = titulacao;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTutulacao() {
		return titulacao;
	}

	public void setTutulacao(String tutulacao) {
		this.titulacao = tutulacao;
	}

}
