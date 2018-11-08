package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.AlunoOuProfessor;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Pessoa;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumGrauAcademico;

public class ProfessorDAO implements DAOInterface<Professor, AlunoOuProfessor> {
	EnumGrauAcademico eg;

	private final String sql = "INSERT INTO pessoa(id,nome,matricula,id_professor) VALUES (?,?,?,?)";
	private final String sql1 = "INSERT INTO professor(titulacao) VALUES (?)";


	@Override
	public void salvar(Professor p, AlunoOuProfessor ap) throws SQLException {
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();
		Pessoa pessoa = new Pessoa();

		try {
			conn.setAutoCommit(false);
			stmt = conn.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
	
			String titulo = p.getEnumGrauAcademico().getGrau();
			stmt.setString(1, titulo);

			int rows = stmt.executeUpdate();
			
			ResultSet rs = stmt.getGeneratedKeys();
			rs.next();
			int idgerado = rs.getInt(1);
			ap.setId(idgerado);
			
			

			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, ap.getId());
			stmt.setString(2, p.getNome());
			stmt.setString(3, p.getMatricula());
			stmt.setInt(4, ap.getId());

			
			
			
			stmt.executeUpdate();
			conn.commit();
			System.out.println("Salvo");
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			System.out.println("ops");
			e.printStackTrace();
		}

	}

}
