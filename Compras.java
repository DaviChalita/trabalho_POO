package bolo;

import java.util.ArrayList;
import java.util.List;

public class Compras {   
    
    public static void realizaPedido(List<Produto> produtosSolicitados) {
        if (!solicitaCapital()) {
            System.out.println("Recursos não autorizados para a realização do pedido");
            return;
        }
        Pedido pedido = criaPedido();
        adicionaItens(pedido, produtosSolicitados);
        List<Produto> produtos = obtemProdutos(pedido);   
        atualizaEstoque(produtos);
        notificaPCP();
    }

    private static boolean solicitaCapital() {
        return true;
    }    
    
    private static Pedido criaPedido(){
        Pedido pedido = new Pedido();
        return pedido;
    }
    
    private static void adicionaItens(Pedido pedido, List<Produto> produtos){
        produtos.forEach((produtoAtual) -> {
            pedido.adicionaItem(produtoAtual);
        });        
    }    

    private static List<Produto> obtemProdutos(Pedido pedido){
        List<Produto> produtos = new ArrayList<>();
        List<ItemPedido> itensPedido = pedido.getItens();
        
        itensPedido.forEach((item) -> {
            Produto produto = new Produto(item.getNome(), item.getQuantidade(), item.getUnidade(), item.getValidade());
            produtos.add(produto);
        });

        return produtos;
    }
    
    private static void atualizaEstoque(List<Produto> produtos){
        System.out.println("Produtos inseridos no estoque: ");
        produtos.forEach((produto) -> {
            System.out.println(produto);
        });
    }
    
    private static void notificaPCP(){
         System.out.println("Se essa mensagem foi exibida saiba que o programa compilou e que você é uma pessoa incrível.");
    }        
}
