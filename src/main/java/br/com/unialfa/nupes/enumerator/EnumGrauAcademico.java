package br.com.unialfa.nupes.enumerator;

public enum EnumGrauAcademico {
	GRAU_GRADUADO(1L, "GRADUADO(A)"), GRAU_BACHAREL(2L, "BACHAREL"), GRAU_POS_GRADUADO(3L, "PÓS-GRADUADO(A)"),
	GRAU_MESTRADO(4L, "MESTRE(A)"), GRAU_DOUTORADO(5L, "DOUTOR(A)");
	
	
	private Long id;
	private String grau;

	private EnumGrauAcademico(Long id, String grau) {
		this.id = id;
		this.grau = grau;
	}

	public String getGrau() {
		return grau;
	}

	public void setGrau(String grau) {
		this.grau = grau;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return this.grau;
	}

}
