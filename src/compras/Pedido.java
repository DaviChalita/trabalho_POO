package compras;

import estoque.Produto;
import java.util.ArrayList;
import java.util.List;

public final class Pedido {
    private List<ItemPedido> itens;
    private float precoTotal;

    public Pedido() {
        this.itens = new ArrayList<>();
        setPrecoTotal(0.0f);
    }

    protected void adicionaItem(Produto produto){
        ItemPedido item = new ItemPedido(
                produto.getNome(), 
                produto.getQuantidade(), 
                produto.getUnidade(), 
                produto.getValidade(), 
                10); 
        this.itens.add(item);         
        this.updatePrecoTotal(item.getPreco());
    }    
    
    public List<ItemPedido> getItens() {
        return itens;
    }

    public float getPrecoTotal() {
        return precoTotal;
    }
    
    private void setPrecoTotal(Float precoTotal) {
        this.precoTotal = precoTotal;
    }   
    
    private void updatePrecoTotal(float valor) {
        this.precoTotal += valor;
    }  
}
