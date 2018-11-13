package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.dao.BancaDAO;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumQtdAluno;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroBancaController implements Initializable {

	@FXML
	private JFXTextField txtNomeBanca;

	@FXML
	private JFXComboBox<?> txtOrientador;

	@FXML
	private JFXComboBox<?> txtLeitor;

	@FXML
	private JFXButton btnAdicionaLeitor;

	@FXML
	private JFXComboBox<Aluno> cbAluno;

	@FXML
	private JFXComboBox<Professor> cbOrientador;

	@FXML
	private JFXComboBox<Aluno> cbAluno2;

	@FXML
	private JFXComboBox<Aluno> cbAluno3;

	@FXML
	private JFXComboBox<EnumQtdAluno> cbQtd;

	@FXML
	private JFXComboBox<Professor> cbLeitor;

	@FXML
	private JFXDatePicker dtData;

	@FXML
	private JFXButton btnSalvar;
	Aluno a = new Aluno();
	private Aluno aluno = new Aluno();
	private List<Aluno> alunos = new ArrayList<>();
	private BancaDAO dao = new BancaDAO();

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {
			pegaAlunos();
			pegaInfoProf();
			pegouEnums();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> pegaAlunos() throws SQLException {
		List<Aluno> alunos = dao.listaAluno();
		cbAluno.getItems().add(null);
		cbAluno2.getItems().add(null);
		cbAluno3.getItems().add(null);
		cbAluno.getItems().addAll(alunos);
		cbAluno2.getItems().addAll(alunos);
		cbAluno3.getItems().addAll(alunos);

		return alunos;
	}

	public List<Professor> pegaInfoProf() throws SQLException {
		List<Professor> professor = dao.listaprofessor();
		cbLeitor.getItems().add(null);
		cbOrientador.getItems().add(null);

		cbLeitor.getItems().addAll(professor);
		cbOrientador.getItems().addAll(professor);
		return professor;

	}
	public void pegouEnums() {
		cbQtd.getItems().add(null);
		cbQtd.getItems().addAll(EnumQtdAluno.values());
	}
}
