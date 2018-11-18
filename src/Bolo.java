import compras.Compras;
import estoque.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bolo {
    
    public static void main(String[] args) {   
        
        List<Produto> produtos = new ArrayList<>();
        
        Produto produto1 = new Produto("Batata", 10, "Kg", new Date());                  
        Produto produto2 = new Produto("Ovos", 1000, "Unidades", new Date());
        
        produtos.add(produto1);
        produtos.add(produto2);
        
        Compras.realizaPedido(produtos);
    }
}
