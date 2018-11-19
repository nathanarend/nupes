package br.com.unialfa.nupes.enumerator;

public enum EnumCurso {
	SISTEMAS_DE_INFORMA��O(1L, "SISTEMAS DE INFORMA��O"), ADMINISTRA��O(2L, "ADMINISTRA��O"),
	ARQUITETURA_URBANISMO(3L, "ARQUITETURA E URBANISMO"), CIENCIAS_CONTABEIS(4L, "CI�NCIAS CONT�BEIS"),
	CIENCIAS_ECONOMICAS(5L, "CI�NCIAS ECON�MICAS"), COM�RCIO_EXTERIOR(6L, "COM�RCIO EXTERIOR"), DIREITO(7L, "DIREITO"),
	ENGENHARIA_CIVIL(8L, "ENGENHARIA CIVIL"), ENGENHARIA_COMPUTACAO(9L, "EGENHARIA DA COMPUTA��O"),
	ENGENHARIA_DE_PRODU��O(10L, "ENGENHARIA DE PRODU��O"), ENGENHARIA_ELETRICA(11L, "ENGENHARIA EL�TRICA"),
	ENGENHARIA_MECACINA(12L, "ENGENHARIA MEC�NICA"), JORNALISMO(13L, "JORNALISMO"), PEDAGOGIA(14L, "PEDAGOGIA"),
	PSICOLOGIA(15L, "PSICOLOGIA"), PUBLICIDADE_PROPAGANDA(16L, "PUBLICIDADE E PROPAGANDA");
	private Long id;
	private String nomeCurso;

	private EnumCurso(Long id, String nomeCurso) {
		this.id = id;
		this.nomeCurso = nomeCurso;
	}

	public String getNomeCurso() {
		return nomeCurso;
	}

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return nomeCurso;
	}

	@Override
	public String toString() {
		return nomeCurso;
	}
}
