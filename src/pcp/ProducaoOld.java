/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp;

import RH.Funcionario;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


/**
 *
 * @author JP and babizinha and clovis
 */
public class ProducaoOld {
    
    private static Receita receita;
    private static Funcionario gerente;
    private static List<Funcionario> equipeOperacional;   
    private boolean comecaProducao;
    private static List<Receita> livroReceita;
    private static Scanner teclado;
    private static SimpleDateFormat formato;
            
    public ProducaoOld() {
    }
    // public Pronto produzReceita(){
        // processo de produção
        // verificaReceita
        // verificaIngredientes
        // alocaEquipe
        // iniciaPreparo
        // testeFinal
        // desalocaEquipe
     //}

    
    // PRONTO
    public static Receita verificaReceita(String nome){
        // recebe a receita que irá ser produzida
        // verifica se ela existe dentro do "banco de dados" da produção
        // se existir, retorna true
        // se não, retorna false
        for(Receita r : livroReceita){
            if((r != null) && (r.getNome().equals(nome))){
                return r;
            }
        }
        return null;
    }
    
    // PRONTO
    public static void criaReceita() throws ParseException{
        teclado = new Scanner(System.in);
        formato = new SimpleDateFormat("HH:mm");
        Receita nova = new Receita();
        System.out.print("Insira o nome da receita: ");
        nova.setNome(teclado.nextLine()); // nome do ingrediente 
        String controle;
        do { // ingredientes
            System.out.print("Insira o nome do ingrediente: ");
            String nomeIngrediente = teclado.nextLine();
            System.out.println("Insira a quantidade do ingrediente: ");
            float quantidadeIngrediente = teclado.nextFloat();
            System.out.println("Insira a unidade do ingrediente: ");
            String unidadeIngrediente = teclado.nextLine();
            nova.getIngredientes().add(new Produto(nomeIngrediente,quantidadeIngrediente,unidadeIngrediente,null));
            System.out.println("Deseja adicionar outro ingrediente (S - sim; N - não)?");
            controle = teclado.next().toUpperCase();
        } while(controle.equals("S"));
        
        System.out.println("Insira o tempo de preparo: [HH:MM] "); // inserindo tempo de preparo
        nova.setTempoPreparo(formato.parse(teclado.nextLine()));
        
        System.out.println("Insira o modo de preparo: "); // inserindo modo de preparo
        nova.setModoPreparo(teclado.nextLine());
        
        System.out.println("Insira a quantidade mínima de pessoas para realizar a receita: "); // inserindo a equipe mínima
        nova.setEquipeMinima(teclado.nextInt());
        
        livroReceita.add(nova);
    }
    
    // PRECISA DA CLASSE 'ESTOQUE'
    public static boolean verificaIngredientes(List<Produto> ingredientes){
        // Se tiver ingredientes, retorna TRUE
        // Se não tiver,  retorna FALSE
        /*
        * percorrerá a lista de ingredientes da receita 
        * verificará se existe o ingrediente no estoque e se existe quantidade suficiente para a receita
        * caso haja, retorna true (a receita será preparada)
        * caso não, retorna false e será feita uma solicitação de compra para o setor de compras
        */
                
        return false;
    }
    
    // PRECISA DA CLASSE 'COMPRAS
    public static void solicitaCompra(){
        // solicitada caso verificaIngredientes() == false
        // solicita ao setor de Compras a compra de novos ingredientes
    }
    
    // PRECISA DO 'RH'
    public static void alocaEquipe(Receita receita){
        // verifica a lista de funcionários para alocar equipe para o projeto
        // se não tiver, retorna false
        // se tiver, aloca a quantidade necessária de acordo com a receita e retorna true
        int total = receita.getEquipeMinima(); // define a quantidade de pessoas que trabalharão
        // Pega lista de funcionários do RH
        List<Funcionario> funcionarios = new ArrayList<>();
//        funcionarios.get(1);
        int index;
        do{
            index = (int) Math.floor(Math.random()*funcionarios.size());
            gerente = funcionarios.get(index);
        }while (gerente.isOcupado());
        // Inicializar listas equipeOreacional e livrereceitas em um lugar melhor
        equipeOperacional = new ArrayList<>();
        do{
            index = (int) Math.floor(Math.random()*funcionarios.size());
            Funcionario f = funcionarios.get(index);
            if (!f.isOcupado()){
                equipeOperacional.add(f);
            }
        }while (equipeOperacional.size() < receita.getEquipeMinima());
        
        
        
    }
    
    // PRECISA DO 'RH'
    public static void solicitaContratacao(){
        // solicitada caso alocaEquipe() == false
        // solicita ao RH contratação de equipe 
    }
    
    // PRECISA DA CLASSE 'ESTOQUE' e 'VENDAS'
    public static void iniciaPreparo(Receita produto, int quantidadeProduto){
        // Início do preparo: mostra na tela cada um dos itens do vetor Produtos sendo acrescentados no bolo com um System.out.print
        // Fim do preparo: mensagem na tela indicando qu eo bolo foi finalizado. 
        List<Produto> ingredientesUtilizados;
        ingredientesUtilizados = produto.getIngredientes();
        System.out.println("Iniciando produção do bolo...");
        for(Produto p : ingredientesUtilizados){
            // criar outro for para percorrer os produtos na classe 'ESTOQUE'
            // buscar o produto p no ESTOQUE e subtrair a quantidade utilizada por p no ESTOQUE
        }
        
       
        System.out.println("Produto finalizado e pronto para testes.");
        System.out.println("Iniciando testes...");
        
        if(testeFinal()){
            System.out.println("Produto aprovado e pronto pra entrega.");
            // encaminha para VENDAS
        }
        else {
            System.out.println("Produto não aprovado. O preparo será reiniciado.");
            iniciaPreparo(produto,quantidadeProduto);
        }
        
    }
    
    // PRONTO
    public static boolean testeFinal(){
        // realiza testes utilizando random
        // se for aprovado é encaminhado para a entrega
        // se não retorna para iniciaPreparo         
        return (float) Math.random() > 0.25;
    }
    
    //PRONTO
    public static void desalocaEquipe(){
        for(Funcionario f : equipeOperacional){
            f = null;
        }
        System.gc();
    }
    
    
    
    
 

    
    
}
