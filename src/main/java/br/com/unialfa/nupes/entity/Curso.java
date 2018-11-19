package br.com.unialfa.nupes.entity;

import br.com.unialfa.nupes.enumerator.EnumCurso;
import br.com.unialfa.nupes.enumerator.EnumPeriodo;
import javafx.beans.property.ObjectProperty;

public class Curso {
	int id_curso;
	String nome;
	EnumCurso curso;
	EnumPeriodo periodod;

	public EnumPeriodo getPeriodod() {
		return periodod;
	}

	public void setPeriodo(EnumPeriodo periodod) {
		this.periodod = periodod;
	}

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



}
