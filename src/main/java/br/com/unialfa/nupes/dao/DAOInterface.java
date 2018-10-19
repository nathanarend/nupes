package br.com.unialfa.nupes.dao;

public interface DAOInterface<T> {
	public void salvar(T obj);

	public void Consultar(Integer id);

	public void limpar(T obj);

}
