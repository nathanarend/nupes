package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Pessoa;
import br.com.unialfa.nupes.enumerator.EnumCurso;

public class AlunoDAO implements DAOInterface {
	EnumCurso ec;

	public void salvar(Aluno aluno) {

		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);
			String sql = "INSERT INTO pessoa(nome,matricula) VALUES(?,?) ";
			// String sql2 = "INSERT INTO aluno(periodo) VALUES(?)";
			String sql2 = "INSERT INTO curso(nome) VALUES (?,?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getMatricula());
			int rows = stmt.executeUpdate();

			stmt = conn.prepareStatement(sql2);
			stmt.setString(1, ec.getNomeCurso());

			stmt.executeUpdate();
			conn.commit();
			System.out.println("Salvo com sucesso!");
			stmt.close();
			conn.close();

		} catch (SQLException e) {
			System.out.println("ops");
			e.printStackTrace();
		}
	}

}
