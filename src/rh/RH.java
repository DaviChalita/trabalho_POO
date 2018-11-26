package rh;

import java.util.*;

public class RH {
    private static List<Funcionario> funcionarios = new ArrayList<>();
  
    public static void contratar(Funcionario funcionario){
         funcionarios.add(funcionario);
    }    
    
    public static void demitir(String cpf) {
        Funcionario funcionario = recuperar(cpf);
        
        if (funcionario != null) 
            funcionarios.remove(funcionario);        
    }
    
    public static Funcionario recuperar(String cpf) {
        for(Funcionario funcionario : funcionarios) {
            if(funcionario.getCpf().equals(cpf)) {     
                return funcionario;                       
            }           
        }
        
        return null;
    }
}
