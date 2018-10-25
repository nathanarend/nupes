package br.com.unialfa.nupes.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.AlunoDAO;
import br.com.unialfa.nupes.dao.DAOInterface;
import br.com.unialfa.nupes.entity.Aluno;
import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Pessoa;
import br.com.unialfa.nupes.enumerator.EnumCurso;
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
	AlunoDAO aluno = new AlunoDAO();
	Aluno a = new Aluno();

	void pegaEnums() {
		cbCurso.getItems().add(null);
		cbCurso.getItems().addAll(EnumCurso.values());
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		pegaEnums();

	}

	private void catchvalues(Aluno a) {
		a.setNome(txtNome.getText());
		a.setMatricula(Integer.parseInt(txtMatricula.getText()));
		cbCurso.getSelectionModel().getSelectedItem();
	}

	@FXML
	private void save() throws IOException {
		catchvalues(a);
		aluno.salvar(a);
	}
}
