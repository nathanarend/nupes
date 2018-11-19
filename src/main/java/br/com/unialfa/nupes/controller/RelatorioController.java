package br.com.unialfa.nupes.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.configuration.ModuloConexao;
import br.com.unialfa.nupes.dao.RelatorioDAO;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Banca;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Declaracao;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumCurso;
import br.com.unialfa.nupes.enumerator.EnumQtdAluno;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

public class RelatorioController implements Initializable {
	Aluno aluno = new Aluno();
	Banca banca = new Banca();

	@FXML
	private Label lblA1;

	@FXML
	private Label lblA2;

	@FXML
	private Label lbA3;

	@FXML
	private AnchorPane PanePrincipal;

	@FXML
	private JFXButton btnDeslogar;

	@FXML
	private JFXComboBox<EnumCurso> cbNomeCurso;

	@FXML
	private JFXComboBox<Banca> cbNomeBanca;

	@FXML
	private JFXComboBox<Professor> cbOrientador;

	@FXML
	private JFXComboBox<Professor> cbLeitor1;

	@FXML
	private JFXComboBox<Professor> CBLeitor2;

	@FXML
	private JFXComboBox<EnumQtdAluno> cbQtdA;

	@FXML
	private JFXComboBox<Aluno> cbAluno1;

	@FXML
	private JFXComboBox<Aluno> cbAluno2;

	@FXML
	private JFXComboBox<Aluno> cbAluno3;

	@FXML
	private JFXTextField txtSemestre;

	@FXML
	private JFXButton btnNovo;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnCancelar;

	@FXML
	private JFXButton btnElimina;

	@FXML
	private TableView<?> TableDoc;

	@FXML
	private TableColumn<?, ?> ColunID;

	@FXML
	private TableColumn<?, ?> ColunCurso;

	@FXML
	private TableColumn<?, ?> ColunBanca;

	@FXML
	private TableColumn<?, ?> ColunSemestre;

	@FXML
	private TableColumn<?, ?> ColunOrientador;

	@FXML
	private TableColumn<?, ?> ColunLeitora;

	@FXML
	private TableColumn<?, ?> ColunLeitorb;

	@FXML
	private TableColumn<?, ?> ColunAlunos;

	@FXML
	private JFXTextField TextBuscar;

	@FXML
	private JFXButton ButtonBuscar;

	@FXML
	private JFXButton ButtonAtualizar;

	@FXML
	private JFXComboBox<?> ComboBuscar;

	RelatorioDAO dao = new RelatorioDAO();

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pegaEnum();
		pegaAlunos();
		pegaProfessor();
		pegaBanca();

	}

	public List<Aluno> pegaAlunos() {
		List<Aluno> alunos = new ArrayList<>();
		try {
			alunos = dao.listaAluno();
			cbAluno1.getItems().add(null);
			cbAluno2.getItems().add(null);
			cbAluno3.getItems().add(null);
			cbAluno1.getItems().addAll(alunos);
			cbAluno2.getItems().addAll(alunos);
			cbAluno3.getItems().addAll(alunos);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return alunos;
	}

	public List<Professor> pegaProfessor() {
		List<Professor> professor = new ArrayList<>();
		try {
			professor = dao.listaprofessor();
			cbOrientador.getItems().add(null);
			CBLeitor2.getItems().add(null);
			cbLeitor1.getItems().add(null);
			cbOrientador.getItems().addAll(professor);
			cbLeitor1.getItems().addAll(professor);
			CBLeitor2.getItems().addAll(professor);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return professor;
	}

	void pegaEnum() {
		cbNomeCurso.getItems().add(null);
		cbQtdA.getItems().add(null);
		cbQtdA.getItems().addAll(EnumQtdAluno.values());
		cbNomeCurso.getItems().addAll(EnumCurso.values());
	}

	public List<Banca> pegaBanca() {
		List<Banca> banca = new ArrayList<>();
		try {
			banca = dao.listaBanca();
			cbNomeBanca.getItems().add(null);
			cbNomeBanca.getItems().addAll(banca);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return banca;
	}

	@FXML
	void selecionaQtd(ActionEvent event) {
		String qqr = cbQtdA.getSelectionModel().getSelectedItem().toString();
		if (qqr == "1") {
			cbAluno2.setVisible(false);
			cbAluno3.setVisible(false);
			lblA2.setVisible(false);
			lbA3.setVisible(false);

		}
		if (qqr == "2") {
			cbAluno1.setVisible(true);
			cbAluno2.setVisible(true);
			cbAluno3.setVisible(false);
			lbA3.setVisible(false);
			lblA1.setVisible(true);
			lblA2.setVisible(true);
		}
		if (qqr == "3") {
			cbAluno1.setVisible(true);
			cbAluno2.setVisible(true);
			cbAluno3.setVisible(true);
			lblA1.setVisible(true);
			lblA2.setVisible(true);
			lbA3.setVisible(true);
		}

	}

	void pegaAllValues() {


		try {
			Curso curso = new Curso();
			Aluno aluno = new Aluno();
			Banca banca = new Banca();
			Professor professor = new Professor();
			Declaracao declaracao = new Declaracao();
			List<Declaracao> dec = new ArrayList<>();
			aluno = cbAluno1.getValue();
			String Aluno1 = aluno.getNome();
			declaracao.setAluno1(Aluno1);
	
			aluno = cbAluno2.getValue();
			String Aluno2 = aluno.getNome();
			declaracao.setAluno2(Aluno2);

			aluno = cbAluno3.getValue();
			String Aluno3 = aluno.getNome();
			declaracao.setAluno3(Aluno3);
	
			EnumCurso enums = cbNomeCurso.getValue();
			String nomeCurso = enums.getNomeCurso();
			declaracao.setNomeCurso(nomeCurso);
	
			banca = cbNomeBanca.getValue();
			String nomeBanca = banca.getNome();
			declaracao.setNomeBanca(nomeBanca);

			declaracao.setSemestre(txtSemestre.getText());

			professor = cbOrientador.getValue();
			String orientador = professor.getNome();
			declaracao.setnProfOrientador(orientador);

			String orientador2 = professor.getNome();
			declaracao.setnProfOrientador2(orientador);
	
			professor = cbLeitor1.getValue();
			String pl = professor.getNome();
			declaracao.setnProfLeitor1(pl);
	
			professor = CBLeitor2.getValue();
			String pl2 = professor.getNome();
			declaracao.setnProfLeitor2(pl2);
			dec.add(declaracao);
			InputStream input = new FileInputStream(
					new File("C:\\Users\\Thiago_Sena\\JaspersoftWorkspace\\MyReports\\DEC.jrxml"));
			JasperReport report = JasperCompileManager.compileReport(input);
			JasperPrint print = JasperFillManager.fillReport(report, null, new JRBeanCollectionDataSource(dec));
			JasperViewer.viewReport(print, false);
		} catch (FileNotFoundException | JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	void geraPdf(ActionEvent event) {
		pegaAllValues();

	}

}
