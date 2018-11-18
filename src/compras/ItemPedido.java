package compras;

import estoque.Produto;
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

    private void setPreco(Float preco) {
        this.preco = preco;
    }
    
}
