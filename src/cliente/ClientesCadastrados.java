package cliente;

import java.util.*;

public class ClientesCadastrados {
    private static List <Cliente> clientes = new ArrayList();
    
    public static void adicionarCliente(Cliente cliente){
        clientes.add(cliente);
    } 
    
    public static Cliente recuperarCliente(String cpf) {
        for(Cliente cliente : clientes) {
            if(cliente.getCpf().equals(cpf)) {  
                System.out.println(cliente.getCpf());
                return cliente;                       
            }           
        }        
        return null;
    }
    
}
