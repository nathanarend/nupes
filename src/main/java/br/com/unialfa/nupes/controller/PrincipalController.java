package br.com.unialfa.nupes.controller;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PrincipalController {
	@FXML
	private JFXButton btnCadastro;
	@FXML
	private JFXButton btnDocumentos;
	@FXML
	private JFXButton btnRelatorio;
	@FXML
	private JFXButton btnDeslogar;
	@FXML
	private AnchorPane panePrincipal;

	void cadastrar(ActionEvent event) throws IOException {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource("/view/FXMLCadastro.fxml");
		Parent fxmlParent = (Parent) FXMLLoader.load(arquivoFXML);
		panePrincipal.getChildren().clear();
		panePrincipal.getChildren().add(fxmlParent);
		Scene scene = new Scene(fxmlParent, 774,521);
	

	}

}
