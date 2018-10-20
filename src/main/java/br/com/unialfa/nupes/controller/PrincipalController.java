package br.com.unialfa.nupes.controller;

import java.awt.event.ActionEvent;
import java.net.URL;

import com.jfoenix.controls.JFXButton;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class PrincipalController {
	@FXML
	private JFXButton btnCadastro;
	@FXML
	private JFXButton btnDocumentos;
	@FXML
	private JFXButton btnRelatorio;
	@FXML
	private JFXButton btnDeslogar;
	
	
	void cadastrar (ActionEvent event) {
		URL arquivoFXML;
		arquivoFXML = getClass().getResource();
	}

}
