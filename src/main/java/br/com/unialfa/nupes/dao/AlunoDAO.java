package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.protocol.Resultset;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.AlunoOuProfessor;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;

public class AlunoDAO implements DAOInterface<Aluno, Curso> {
	EnumCurso ec;
	Curso curs = new Curso();

	private final String salvar1 = "INSERT INTO pessoa(id,nome,matricula,id_aluno) VALUES (?,?,?,?)";
	private final String salvar3 = "INSERT INTO aluno(periodo) VALUES (?)";
	private final String salvar2 = "INSERT INTO curso(id,Nome) VALUES (?,?)";

	public void salvar(Aluno aluno, Curso curso) throws SQLException {
		// Aluno aluno = new Aluno();
		AlunoOuProfessor ap = new AlunoOuProfessor();
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();

		try {
			conn.setAutoCommit(false);

			stmt = conn.prepareStatement(salvar3, Statement.RETURN_GENERATED_KEYS);
			String p = curso.getPeriodod().getPeriodo();
			stmt.setString(1, p);
			
			int rows = stmt.executeUpdate();
			
			ResultSet rs1 = stmt.getGeneratedKeys();
			rs1.next();
			int idgerado = rs1.getInt(1);
			ap.setId(idgerado);

			
			stmt = conn.prepareStatement(salvar1);
			stmt.setInt(1, ap.getId());
			stmt.setString(2, aluno.getNome());
			stmt.setString(3, aluno.getMatricula());
			stmt.setInt(4, ap.getId());
			int rowws = stmt.executeUpdate();
//		    ResultSet rs = stmt.getGeneratedKeys();
//			rs.next();
//
//			int IdGenerated = rs.getInt(1);
//			aluno.setId_curso(IdGenerated);

			stmt = conn.prepareStatement(salvar2);
			String c = curso.getCurso().getNomeCurso();
			stmt.setInt(1, ap.getId());
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
