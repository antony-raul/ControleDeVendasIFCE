/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controledevendasifce.DAO;

import controledevendasifce.model.domain.Cliente;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author USUARIO
 */
public class ClienteDAO {
    private List<Cliente> listClientes = new ArrayList<>();
    
    private static ClienteDAO clienteDAO = null;
    
    private ClienteDAO(){
        
    }
    
    public static ClienteDAO singleton(){
        if(clienteDAO == null){
            clienteDAO = new ClienteDAO();
        }
        return clienteDAO;
    }
    
    public List<Cliente> loadCliente(){
        return this.listClientes;
    }
    public void insertCliente(Cliente c){
        this.listClientes.add(c);
    }
    
    public void uptadeCliente(Cliente cliente){
        
    }
    public void removeCliente(Cliente cliente){
        
    }
    
}
