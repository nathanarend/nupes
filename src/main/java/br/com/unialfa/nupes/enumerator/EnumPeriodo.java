package br.com.unialfa.nupes.enumerator;

public enum EnumPeriodo {
	PERIODO_1(1L, "1º"), PERIODO_2(2L, "2º"), PERIODO_3(3L, "3º"), PERIODO_4(4L, "4º"),
	PERIODO_5(5L, "5º"), PERIODO_6(6L, "6º"), PERIODO_7(7L, "7º"), PERIODO_8(8L, "8º");

	private Long id;
	private String periodo;

	private EnumPeriodo(Long id, String periodo) {
		this.id = id;
		this.periodo = periodo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	@Override
	public String toString() {
		return periodo;
	}
}
