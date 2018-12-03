import compras.Compras;
import estoque.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bolo {
    
    public static void main(String[] args) {   
        
        List<Produto> produtos = new ArrayList<>();
        
        Produto batatas = new Produto("Batata", 4, "Kg", new Date());                  
        Produto ovos = new Produto("Ovos", 200, "Unidades", new Date());
        Produto acucar = new Produto("Açucar", 5, "Kg", new Date());
        Produto margarina = new Produto("Margarina", 2, "Kg", new Date());
        Produto manteiga = new Produto("manteiga", 2, "Kg", new Date());
        Produto leite = new Produto("Leite", 20, "L", new Date());
        
        produtos.add(batatas);
        produtos.add(ovos);
        produtos.add(acucar);
        produtos.add(margarina);
        produtos.add(manteiga);
        produtos.add(leite);
        
        Compras.realizaPedido(produtos);
    }
}
