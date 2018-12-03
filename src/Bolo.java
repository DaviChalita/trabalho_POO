import compras.Compras;
import estoque.Produto;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Bolo {
    
    public static void main(String[] args) {   
        
        List<Produto> produtos = new ArrayList<>();
        
        // 1 - Cliente realiza pedido de bolos
        // 2 - Verifica disponibilidade em estoque dos bolos
            // Se tiver
                // A - Vá para (3)
            // Se NÃO tiver
                // A - Encaminha pedido de procução ao PCP
                // B - PCP verifica existência de receita
                    // Se existir
                        // i - Continua produção
                    // Se NÃO existir
                        // i - Desenvolve receita
                        // ii - (?) Verificar capacidade de produção
                 // C - Aloca equipe
                    // Verifica disponibilidade de confeteiros
                        // Se houverem disponíveis
                            // i - Aloca gerente
                            // ii - Aloca restante da equipe
                        // Se NÃO houver disponibilidade
                            // i - Solicita contratação ao RH
                // D -  Verifica quantidade de produtos em estoque para execução da receita 
                    // Se houver ingredientes
                        // i - Continua produção
                    // Se NÃO houver
                        // i - Solicita compra ao setor de Compras
                // E - Produz pedido
                // F - Testa bolo(s)
                    // Se for APROVADO
                        // i - Atualiza estoque
                        // ii - Notifica vendas
                    // Se for REPROVADO
                        // i - Volta para (2-D)
        //3 - Emite nota fiscal
        // 4 - Verifica pagamento
            // Se efetivado
                // i - Emite nota fiscal
                // ii - Entrega produto
            // Se NÃO efetivado
                // i - Avisa ao cliente falta de pagamento
                // ii - Volta para (4)
        
        
        Produto produto1 = new Produto("Batata", 10, "Kg", new Date());                  
        Produto produto2 = new Produto("Ovos", 1000, "Unidades", new Date());
        
        produtos.add(produto1);
        produtos.add(produto2);
        
        Compras.realizaPedido(produtos);
    }
}
