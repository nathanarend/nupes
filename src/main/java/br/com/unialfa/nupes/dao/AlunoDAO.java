package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;

public class AlunoDAO implements DAOInterface<Aluno,Curso> {
	EnumCurso ec;
	Curso curs = new Curso();

	private final String salvar1 = "INSERT INTO pessoa(nome,matricula) VALUES (?,?)";
	private final String salvar2 = "INSERT INTO curso(Nome) VALUES (?)";

	public void salvar(Aluno aluno, Curso curso) {
		// Aluno aluno = new Aluno();

		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(salvar1);
			
			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			int rows = stmt.executeUpdate();
			
			stmt = conn.prepareStatement(salvar2);
			String c = curso.getCurso().getNomeCurso();
			stmt.setString(1, c);
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
