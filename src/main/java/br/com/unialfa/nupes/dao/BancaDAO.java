package br.com.unialfa.nupes.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Professor;

public class BancaDAO {

	 public  List<Aluno> listaAluno() throws SQLException {
		List<Aluno> listaAluno = new ArrayList<>();
		PreparedStatement stmt = null;
		Connection conn = ModuloConexao.GetConnection();


		try {
			
			String sql = "SELECT nome  FROM aluno";
			stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				Aluno aluno = new Aluno();
				aluno.setNome(rs.getString("nome"));
				listaAluno.add(aluno);
			}
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listaAluno;

	}
	 
	 public List<Professor> listaprofessor() throws SQLException{
		 List<Professor> professores = new ArrayList<>();
		 PreparedStatement stmt = null;
		 Connection conn = ModuloConexao.GetConnection();
		 try {
			 String sql = "SELECT nome FROM professor";
			 stmt = conn.prepareStatement(sql);
			 ResultSet rs = stmt.executeQuery(sql);
			 	while(rs.next()) {
			 		Professor professor = new Professor();
			 		professor.setNome(rs.getString("nome"));
			 		professores.add(professor);
			 	}
			 	stmt.close();
			 	conn.close();
		 }catch (SQLException e) {
			 e.printStackTrace();
		 }
		 return professores;
		 
		 
	 }
}
