package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.BancaDAO;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Banca;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumQtdAluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import sun.util.calendar.BaseCalendar.Date;

public class CadastroBancaController implements Initializable {

	@FXML
	private JFXTextField txtNomeBanca;
	@FXML
	private Label txtAluno1, txtAluno2, txtAluno3;
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
	private Professor prof = new Professor();
	private Banca banca = new Banca();
	private List<Aluno> alunos = new ArrayList<>();
	private BancaDAO dao = new BancaDAO();
	static private List<Professor> professor = new ArrayList<>();
	static private List<Aluno> alunoArmazena = new ArrayList<>();
	static int idAluno1;
	static int idAluno2;
	static int idAluno3;
	private LocalDate data;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		try {

			pegaAlunos();
			pegaInfoProf();
			pegouEnums();
			System.out.println(professor);
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

	@FXML
	void adicionaProfOrientador(ActionEvent event) {
		String qqr = cbQtd.getSelectionModel().getSelectedItem().toString();
		int resposta = JOptionPane.showConfirmDialog(null,
				"Deseja adicionar um novo Professor(a) Orientador(a) � BANCA?", null, JOptionPane.YES_NO_OPTION);
		if (resposta == JOptionPane.YES_OPTION) {
			Professor prof = new Professor();
			prof = cbOrientador.getValue();
			prof.getId();
			professor.add(prof);
			cbLeitor.getSelectionModel().clearAndSelect(0);

		}
		cbLeitor.getSelectionModel().clearAndSelect(0);

	}

	@FXML
	void save(ActionEvent event) throws SQLException {

		selecionaAluno();
		selecionaProfessores();
		pegaValores(banca);
		dao.save(banca);
		dao.vinculaBanca(alunoArmazena, professor);

	}

	void pegaValores(Banca b) {
		banca.setNome(txtNomeBanca.getText());
		
		LocalDate temp = dtData.getValue();
		java.sql.Date date = java.sql.Date.valueOf(temp);
		banca.setData(date);
		

	}

	@FXML
	void selecionaQtd(ActionEvent event) {
		String qqr = cbQtd.getSelectionModel().getSelectedItem().toString();
		if (qqr == "1") {
			cbAluno2.setVisible(false);
			cbAluno3.setVisible(false);
			txtAluno2.setVisible(false);
			txtAluno3.setVisible(false);

		}
		if (qqr == "2") {
			cbAluno.setVisible(true);
			cbAluno2.setVisible(true);
			txtAluno2.setVisible(true);
			cbAluno3.setVisible(false);
			txtAluno3.setVisible(false);
		}
		if (qqr == "3") {
			cbAluno.setVisible(true);
			cbAluno2.setVisible(true);
			cbAluno3.setVisible(true);
			txtAluno2.setVisible(true);
			txtAluno3.setVisible(true);
		}

	}

	void selecionaAluno() {
		String qqr = cbQtd.getSelectionModel().getSelectedItem().toString();
		Aluno a = new Aluno();
		if (qqr == "1") {
			a = cbAluno.getValue();
			a.getId();
			alunoArmazena.add(a);

		}
		if (qqr == "2") {
			a = cbAluno.getValue();
			a.getId();
			alunoArmazena.add(a);
			a = cbAluno2.getValue();
			a.getId();
			alunoArmazena.add(a);

		}
		if (qqr == "3") {
			a = cbAluno.getValue();
			a.getId();
			alunoArmazena.add(a);
			a = cbAluno2.getValue();
			a.getId();
			alunoArmazena.add(a);
			a = cbAluno3.getValue();
			a.getId();
			alunoArmazena.add(a);
		}

	}

	void selecionaProfessores() {
		String qqr = cbLeitor.getSelectionModel().getSelectedItem().toString();
		String qqr2 = cbOrientador.getSelectionModel().getSelectedItem().toString();
		Professor prof = new Professor();
		prof = cbLeitor.getValue();
		prof.getId();
		professor.add(prof);
		prof = cbOrientador.getValue();
		prof.getId();
		professor.add(prof);
	}

}
