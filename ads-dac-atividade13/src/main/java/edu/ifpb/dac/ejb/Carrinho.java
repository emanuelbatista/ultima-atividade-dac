package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateful;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Stateful
public class Carrinho {

    private List<Produto> produtos = new ArrayList<>();
    
    public void addProduto (Produto produto){
        produtos.add(produto);
    }
    
}
