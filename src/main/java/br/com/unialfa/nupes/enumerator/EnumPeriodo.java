package br.com.unialfa.nupes.enumerator;

public enum EnumPeriodo {
	PERIODO_1(1L, "1�"), PERIODO_2(2L, "2�"), PERIODO_3(3L, "3�"), PERIODO_4(4L, "4�"),
	PERIODO_5(5L, "5�"), PERIODO_6(6L, "6�"), PERIODO_7(7L, "7�"), PERIODO_8(8L, "8�");

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
