package br.com.unialfa.nupes.entity;

public class Professor {

	private String matricula;
	private String titulacao;
	private int id_curso;

	public Professor() {

	}

	public Professor(String matricula, String titulacao, int id_curso) {
		this.matricula = matricula;
		this.titulacao = titulacao;
		this.id_curso = id_curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public String getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(String titulacao) {
		this.titulacao = titulacao;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getTutulacao() {
		return titulacao;
	}

	public void setTutulacao(String tutulacao) {
		this.titulacao = tutulacao;
	}

}
