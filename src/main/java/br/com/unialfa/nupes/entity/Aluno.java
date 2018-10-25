package br.com.unialfa.nupes.entity;

public class Aluno extends Pessoa{

	int id;
	int periodo;

	public Aluno() {

	}

	public Aluno(int id, int periodo) {
		this.periodo = periodo;
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getPeriodo() {
		return periodo;
	}

	public void setPeriodo(int periodo) {
		this.periodo = periodo;
	}
}
