package it.polito.tdp.anagrammi;

import it.polito.tdp.anagrammi.model.Model;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class FXMLController {

	private Model model;
	
    @FXML
    private TextArea txtCorretti;

    @FXML
    private TextArea txtErrati;
    
    @FXML
    private TextField txtParola;

    @FXML
    void doAnagrammi(ActionEvent event) {
    	
    	this.txtCorretti.clear();
    	this.txtErrati.clear();
    	
    	this.model.anagrammi(txtParola.getText());
    	
    	for(String s:model.getCorretti()) {
    		this.txtCorretti.appendText(s + "\n");
    	}
    	
    	for(String s:model.getErrati()) {
    		this.txtErrati.appendText(s + "\n");
    	}
    }

    @FXML
    void doReset(ActionEvent event) {
    	txtCorretti.clear();
    	txtErrati.clear();
    	txtParola.clear();
    }
    
    public void setModel(Model model) {
    	this.model = model;
    }


}
