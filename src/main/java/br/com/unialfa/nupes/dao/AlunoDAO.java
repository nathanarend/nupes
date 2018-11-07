package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;

public class AlunoDAO implements DAOInterface<Aluno,Curso> {
	EnumCurso ec;
	Curso curs = new Curso();

	private final String salvar1 = "INSERT INTO pessoa(nome,matricula) VALUES (?,?)";
	private final String salvar2 = "INSERT INTO curso(id,Nome) VALUES (?,?)";

	public void salvar(Aluno aluno, Curso curso) throws SQLException {
		// Aluno aluno = new Aluno();

		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(salvar1, Statement.RETURN_GENERATED_KEYS);

			stmt.setString(1, aluno.getNome());
			stmt.setString(2, aluno.getMatricula());
			int rows = stmt.executeUpdate();
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();

			int IdGenerated = rs.getInt(1);
			aluno.setId_curso(IdGenerated);

			stmt = conn.prepareStatement(salvar2);
			String c = curso.getCurso().getNomeCurso();
			stmt.setInt(1, aluno.getId_curso());
			stmt.setString(2, c);
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
