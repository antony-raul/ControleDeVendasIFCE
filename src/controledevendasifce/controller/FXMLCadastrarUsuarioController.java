/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import controledevendasifce.DAO.ClienteDAO;
import controledevendasifce.model.domain.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLCadastrarUsuarioController implements Initializable {

    @FXML
    private TextField textFieldTelefone;

    @FXML
    private TextField textFieldNome;

    @FXML
    private TextField textFieldCPF;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    private Cliente cliente;
    private Stage stage;
    boolean flagConfirmacao = false;


    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public boolean isFlagConfirmacao() {
        return flagConfirmacao;
    }

    public void setFlagConfirmacao(boolean flagConfirmacao) {
        this.flagConfirmacao = flagConfirmacao;
    }
    
    @FXML
    public void handlerCancelar(){
        setFlagConfirmacao(false);
        getStage().close();
    }
    
    public void handlerConfirmar(){
        
        this.cliente = new Cliente(textFieldNome.getText().toString(),textFieldCPF.getText().toString(),textFieldTelefone.getText().toString());
        
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        
        clienteDAO.insertCliente(cliente);
        
        setFlagConfirmacao(true);
        getStage().close();
    }

    
    
}
