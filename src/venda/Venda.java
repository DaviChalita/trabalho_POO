package venda;

import java.util.*;
import estoque.Produto;

public class Venda {
    private List<Produto> carrinho = new ArrayList();

    public void listaItens() {
        for (int i = 0; i < carrinho.size(); i++) {
            System.out.println(carrinho.get(i));
        }
    }

    protected void adicionaItem(Produto produto) {
        carrinho.add(produto);
    }

    protected void removeItens(String nomeProduto) {        
        for (int i = 0; i < carrinho.size(); i++) {
            Produto p = carrinho.get(i);
            
            if (p.getNome().equals(nomeProduto)) {
                carrinho.remove(p);
                return;
            }
        }
    }

    protected void vendeProdutos() {
        carrinho.clear();
    }
}
