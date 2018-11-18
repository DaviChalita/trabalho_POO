package estoque;

import java.util.ArrayList;
import java.util.List;

public class Estoque {
    private static final List<Produto> produtos = new ArrayList<>();    
    
    public static List<Produto> getProdutos() {
        return produtos;
    }
    
    public static void adicionaProduto(Produto produto) {
        int index = buscaProduto(produto.getNome());        
        
        if (index == -1) 
            produtos.add(produto);
        
        else 
            atualizaQuantidadeProduto(produtos.get(index), produto.getQuantidade()) ;                                          
    }

    public static void removeProduto(String nome, int quantidade) {
        int index = buscaProduto(nome);
        
        if (index != -1) 
            System.out.println("Não foi encontrado este produto!"); 
        
        else {
            float quantidadeAtual = produtos.get(index).getQuantidade();
            
            if(quantidadeAtual - quantidade <= 0) { 
                System.out.println("Não há toda essa quantidade para ser removida");
                
            } else {
                atualizaQuantidadeProduto(produtos.get(index), quantidade*-1);
                
                if (produtos.get(index).getQuantidade() == 0)
                    produtos.remove(index);
            }
        }          
    }
    
    public static int buscaProduto(String nome) {
        for (Produto produto : produtos) {
            if (produto.getNome().equals(nome))
                return produtos.indexOf(produto);             
        }
        
        return -1;                    
    }
    
    private static void atualizaQuantidadeProduto(Produto produto, float quantidade) {
        produto.setQuantidade(produto.getQuantidade() + quantidade);
    }        
}
