package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.AlunoDAO;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.enumerator.EnumCurso;
import br.com.unialfa.nupes.enumerator.EnumPeriodo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroAlunoController implements Initializable {
	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXButton btnCancelar;

	@FXML
	private JFXTextField txtMatricula;
	@FXML
	private JFXComboBox<EnumCurso> cbCurso;
	@FXML
	private JFXComboBox<EnumPeriodo> cbPeriodo;
	AlunoDAO aluno = new AlunoDAO();
	Aluno a = new Aluno();
	Curso c = new Curso();

	
	void pegaEnums() {
		cbCurso.getItems().add(null);
		cbPeriodo.getItems().add(null);
		cbCurso.getItems().addAll(EnumCurso.values());
		cbPeriodo.getItems().addAll(EnumPeriodo.values());

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pegaEnums();
		

	}

	private void catchvalues(Aluno a, Curso c) {
		a.setNome(txtNome.getText());
		a.setMatricula(txtMatricula.getText());
		c.setCurso(cbCurso.getValue());
		c.setPeriodo(cbPeriodo.getValue());

	}

	@FXML
	private void save(ActionEvent event) throws SQLException {
		catchvalues(a, c);
		aluno.salvar(a, c);

	}
}
