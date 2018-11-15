package bolo;

import java.util.Date;

public class Produto {
    private String nome;
    private float quantidade;
    private String unidade;
    private Date validade;
    
    public Produto(String nome, float quantidade, String unidade, Date validade) {
        this.setNome(nome);
        this.setQuantidade(quantidade);
        this.setUnidade(unidade);
        this.setValidade(validade);
    }

    public String getNome() {
        return nome;
    }
    
    public float getQuantidade() {
        return quantidade;
    }
        
    public String getUnidade() {
        return unidade;
    }
       
    public Date getValidade() {
        return validade;
    }
    
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setQuantidade(float quantidade) {
        this.quantidade = quantidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public void setValidade(Date validade) {
        this.validade = validade;
    }

    @Override
    public String toString() {
        return "[" +
               this.getNome() + ", " +
               this.getQuantidade() + " " +
               this.getUnidade() + ", válido até " +
               this.getValidade() +
               "]";                
    }    
}
