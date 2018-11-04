package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;

public class CursoDAO implements DAOInterface<Curso> {
	Curso curso = new Curso();

	@Override
	public void salvar(Curso curso) {
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO curso(Nome) VALUES (?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, curso.getNome());
			int rows = stmt.executeUpdate();
			conn.commit();
			stmt.close();
			conn.close();
			System.out.println("salvo");
		} catch (SQLException e) {
			System.out.println("erro");
			System.out.println(e);
		}

	}
}
