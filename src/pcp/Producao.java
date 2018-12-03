/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pcp;

import estoque.Produto;
import java.text.SimpleDateFormat;
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
        // Verifica existencia da receita
        Receita receitaProduzida = verificaReceita(nomeReceita);
        if (receitaProduzida == null){
            //receitaProduzida = criaReceita("Teste", ingredientes, tempoPreparo, nomeReceita, 0);
        }
        else{
            
        }
        // Aloca equipe
        // Verifica ingredientnes
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
    
    public static Receita criaReceita(String nome, List<Produto> ingredientes, Date tempoPreparo, String modoPreparo, int equipeMin){
        // Cria formater para tempo de preparo
        formato = new SimpleDateFormat("HH:mm");
        // Instancia uma nova receita com dados do Swing
        Receita novaReceita = new Receita(nome, ingredientes, new Date(formato.format(tempoPreparo)), modoPreparo, equipeMin);
        // Adiciona receita ao livro de receitas
        livroReceita.add(novaReceita);
        // Retorna uma nova receita
        return novaReceita;
    }
    
    public static void alocaEquipe(Receita receita){
        int equipeMin = receita.getEquipeMinima(), index;
        Funcionario gerente;
        
        // Verificar disponibilidade de funcionários
        
        // Seleciona um gerente
        do{
            index = (int) Math.floor(Math.random() * (RH.getFuncionarios().size()));
            gerente = RH.recuperar(index);
        } while (gerente.isAlocado());
        // Muda estado de alocação
        // Não sei se essa redundância é necessária
        // TESTAR REDUNDÂNCIA
        RH.recuperar(index).alocaFuncionario();
        gerente.alocaFuncionario();
        
        // Alocar equipe técnica
    }
    
    public static boolean testaProduto(){
        return ((float) Math.random()) > 0.25f;
    }
    
    
    
    
    
    
    
    
    private Funcionario gerente;
    private List<Funcionario> equipeTecnica;
    private Receita receita;

    public Producao() {
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
