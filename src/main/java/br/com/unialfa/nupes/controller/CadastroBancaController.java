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
	private JFXComboBox<?> txtAluno2;

	@FXML
	private JFXComboBox<?> txtAluno3;

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
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Aluno> pegaAlunos() throws SQLException {
		List<Aluno> alunos = dao.listaAluno();
		cbAluno.getItems().add(null);
		cbAluno.getItems().addAll(alunos);
		return alunos;
	}

	
}
