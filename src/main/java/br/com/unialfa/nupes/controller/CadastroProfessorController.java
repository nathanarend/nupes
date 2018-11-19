package br.com.unialfa.nupes.controller;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;

import br.com.unialfa.nupes.dao.ProfessorDAO;

import br.com.unialfa.nupes.entity.Curso;
import br.com.unialfa.nupes.entity.Professor;
import br.com.unialfa.nupes.enumerator.EnumGrauAcademico;
import br.com.unialfa.nupes.enumerator.EnumSexo;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

public class CadastroProfessorController implements Initializable {
	Professor professor = new Professor();
	Curso curso = new Curso();
//
	ProfessorDAO pd = new ProfessorDAO();
	@FXML
	private JFXTextField txtNome;

	@FXML
	private JFXButton btnSalvar;

	@FXML
	private JFXTextField txtMatricula;

	@FXML
	private JFXComboBox<EnumGrauAcademico> cbTitularidade;
	@FXML
	private JFXComboBox<EnumSexo> cbSexo;

	void pegaEnum() {
		cbTitularidade.getItems().add(null);
		cbSexo.getItems().add(null);
		cbTitularidade.getItems().addAll(EnumGrauAcademico.values());
		cbSexo.getItems().addAll(EnumSexo.values());
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pegaEnum();

	}

	private void catchitems(Professor prof, Curso curso) {
		prof.setNome(txtNome.getText());
		prof.setMatricula(txtMatricula.getText());
		prof.setEnumGrauAcademico(cbTitularidade.getValue());
		prof.setEnumSexo(cbSexo.getValue());

	}
	@FXML
	private void save(ActionEvent event) throws SQLException {
		catchitems(professor, curso);
		pd.salvar(professor, curso);

	}

}
