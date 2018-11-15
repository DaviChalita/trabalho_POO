package bolo;

import java.util.Date;

public final class ItemPedido extends Produto {    
    private float preco;

    public ItemPedido(String nome, float quantidade, String unidade, Date validade, float preco) {
        super(nome, quantidade, unidade, validade);
        this.setPreco(preco);
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(Float preco) {
        this.preco = preco;
    }

    public void setPreco(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }          
}
