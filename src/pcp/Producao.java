/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp;

import estoque.Produto;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import rh.Funcionario;
import rh.RH;

/**
 *
 * @author JP
 */
public class Producao {
    
    private static List<Receita> livroReceita;
    private static List<Producao> linhaProducao;
    private static SimpleDateFormat formato;
    
    public static void solicitaProducao(String nomeReceita, int quantidade){
        
        Producao producaoReceita = new Producao();
        // Verifica existencia da receita
        producaoReceita.setReceita(verificaReceita(nomeReceita));
        if (producaoReceita.getReceita() == null){
            //receitaProduzida = criaReceita("Teste", ingredientes, tempoPreparo, nomeReceita, 0);
        }        
        // Aloca equipe
        boolean resAlocaEquipe = alocaEquipe(producaoReceita);
        // Verifica ingredientnes
            // Mudança do código deles
        
        // Produz bolo
        
        // Testa bolo
        // Atualiza estoque
        // Notifica Venda
    }
    
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
    
    public static Receita criaReceita(String nome, List<Produto> ingredientes, String tempoPreparo, String modoPreparo, int equipeMin){
        // Cria formater para tempo de preparo
        formato = new SimpleDateFormat("HH:mm");
        // Instancia uma nova receita com dados do Swing
        Receita novaReceita = new Receita(nome, ingredientes, new Date(formato.format(tempoPreparo)), modoPreparo, equipeMin);
        // Adiciona receita ao livro de receitas
        livroReceita.add(novaReceita);
        // Retorna uma nova receita
        return novaReceita;
    }
    
    public static boolean alocaEquipe(Producao producao){
        int equipeMin = producao.getReceita().getEquipeMinima(), index;
        Funcionario gerente = new Funcionario();
        
        // Recebe nome do gerente da view
        
        // Aloca gerente
         producao.setGerente(gerente);

        // Aloca funcionários
        for(Funcionario f : RH.getFuncionarios()){
            if(equipeMin > producao.getEquipeTecnica().size() && !f.isAlocado()){
                producao.getEquipeTecnica().add(f);
                f.alocaFuncionario();
            }
        }
        if(equipeMin>producao.getEquipeTecnica().size()){
            // Solicita contratação
            
            // Aloca equipe novamente
            return alocaEquipe(producao);
        }
        
        // Retorna true caso tenha conseguido alocar equipe
        return true;
    }
    
    public static boolean produzBolo(Producao producao){
        
        // Tira ingredientes do estoque
        
        
        return true;
    }
    
    public static boolean testaProduto(){
        return ((float) Math.random()) > 0.25f;
    }
    
    
    
    
    
    
    
    
    private Funcionario gerente;
    private List<Funcionario> equipeTecnica;
    private Receita receita;

    public Producao() {
        this.equipeTecnica = new ArrayList<>();
    }

    public Producao(Funcionario gerente, Receita receita) {
        this.gerente = gerente;
        this.receita = receita;
        this.equipeTecnica = new ArrayList<>();
    }

    public Producao(Funcionario gerente, List<Funcionario> equipeTecnica, Receita receita) {
        this.gerente = gerente;
        this.equipeTecnica = equipeTecnica;
        this.receita = receita;
    }

    public Funcionario getGerente() {
        return gerente;
    }

    public void setGerente(Funcionario gerente) {
        this.gerente = gerente;
    }

    public List<Funcionario> getEquipeTecnica() {
        return equipeTecnica;
    }

    public void setEquipeTecnica(List<Funcionario> equipeTecnica) {
        this.equipeTecnica = equipeTecnica;
    }

    public Receita getReceita() {
        return receita;
    }

    public void setReceita(Receita receita) {
        this.receita = receita;
    }

}
