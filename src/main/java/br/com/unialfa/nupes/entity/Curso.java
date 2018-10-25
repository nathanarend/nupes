package br.com.unialfa.nupes.entity;


import br.com.unialfa.nupes.enumerator.EnumCurso;
import javafx.beans.property.ObjectProperty;

public class Curso {
	int id;
	private ObjectProperty<EnumCurso> curso;

	public final ObjectProperty<EnumCurso> cursoProperty() {
		return this.curso;
	}

	public final EnumCurso getCurso() {
		return this.cursoProperty().get();
	}

	public final void setCurso(final EnumCurso curso) {
		this.cursoProperty().set(curso);
	}

}
