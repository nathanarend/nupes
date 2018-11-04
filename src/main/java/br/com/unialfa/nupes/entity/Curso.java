package br.com.unialfa.nupes.entity;

import br.com.unialfa.nupes.enumerator.EnumCurso;
import javafx.beans.property.ObjectProperty;

public class Curso {
	int id_curso;
	String nome;
	EnumCurso curso;

	public EnumCurso getCurso() {
		return curso;
	}

	public void setCurso(EnumCurso curso) {
		this.curso = curso;
	}

	public int getId_curso() {
		return id_curso;
	}

	public void setId_curso(int id_curso) {
		this.id_curso = id_curso;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	/*
	 * public void setCurso(ObjectProperty<EnumCurso> curso) { this.curso = curso; }
	 * 
	 * private ObjectProperty<EnumCurso> curso;
	 * 
	 * public final ObjectProperty<EnumCurso> cursoProperty() { return this.curso; }
	 * 
	 * public final EnumCurso getCurso() { return this.cursoProperty().get(); }
	 * 
	 * public final void setCurso(final EnumCurso curso) {
	 * this.cursoProperty().set(curso); }
	 */

}
