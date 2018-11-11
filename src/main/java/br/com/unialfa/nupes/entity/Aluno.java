package br.com.unialfa.nupes.entity;

public class Aluno extends Pessoa {

	private String matricula;

	private int id_curso;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public Aluno() {
	}

	public Aluno(int id_curso) {
		this.id_curso = id_curso;

	}
	@Override
	public String toString() {
		return nome;
	}

}
