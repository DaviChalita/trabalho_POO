package projetopoo.rh;

import java.util.*;

public class RH {
    List<Funcionario> quadroFuncionarios = new ArrayList<>();
  
    public void contratar(Funcionario f){
         quadroFuncionarios.add(f);
         System.out.println("Cadastrado: "+f.getNome());
    }    
    
    public void demitir(String cpf) {
        Funcionario f = recuperar(cpf);
        
        if (f != null) 
            quadroFuncionarios.remove(f);        
    }
    
    public Funcionario recuperar(String cpf) {
        for(Funcionario f : quadroFuncionarios) {
            if(f.getCpf().equals(cpf))     {     
                return f;                       
            }           
        }
        
        return null;
    }
}
