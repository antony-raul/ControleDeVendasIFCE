/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.controller;

import controledevendasifce.DAO.ClienteDAO;
import controledevendasifce.model.domain.Cliente;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Usuario
 */
public class FXMLCadastroClienteController implements Initializable {

    @FXML
    private TableColumn<Cliente, String> tblColNome;

    @FXML
    private TableColumn<Cliente, String> tblColTelefone;

    @FXML
    private TableView<Cliente> tabelaCliente;

    @FXML
    private TableColumn<Cliente, String> tblColCPF;
    
    @FXML
    private Button btnCadastrar;

    @FXML
    private Button btnAlterar;
    
    @FXML
    private Button btnRemover;
    
    List<Cliente> listCliente;
    ObservableList<Cliente> observableList;
    
    
    
    @FXML
    public void showDialog(Cliente c) throws IOException{
        FXMLLoader fxmll = new FXMLLoader();
        fxmll.setLocation(FXMLCadastrarUsuarioController.class.getResource("/controledevendasifce/view/FXMLCadastrarUsuario.fxml"));
        AnchorPane anchorPane = (AnchorPane) fxmll.load();
        
        Scene scene = new Scene(anchorPane);
        Stage stage = new Stage();
        stage.setScene(scene);
        
        FXMLCadastrarUsuarioController controller = fxmll.getController();
        controller.setCliente(c);
        controller.setStage(stage);
        
        
        stage.showAndWait();
        
        if(controller.isFlagConfirmacao()){
            loadClientes();
        }
       }
    
    @FXML
    public void janelaCadastrar()throws IOException{
        showDialog(null);
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       loadClientes();
    }    
    public void loadClientes(){
        tblColNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tblColCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        tblColTelefone.setCellValueFactory(new PropertyValueFactory<>("telefone"));
        ClienteDAO clienteDAO = ClienteDAO.singleton();
        observableList = FXCollections.observableArrayList(clienteDAO.loadCliente());
        tabelaCliente.refresh();
        tabelaCliente.setItems(observableList);
        
    }
    
    
}
