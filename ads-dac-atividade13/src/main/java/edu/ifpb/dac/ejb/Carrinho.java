package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Pedido;
import edu.ifpb.dac.Produto;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.ejb.EJB;
import javax.ejb.Stateful;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Stateful
public class Carrinho {

    private Set<Produto> produtosDoUsuario = new HashSet<>();
    
    public void addProduto (Produto produto){
        produtosDoUsuario.add(produto);
    }
    
    public void removeProduto (Produto produto){
        produtosDoUsuario.remove(produto);
    }

    public Set<Produto> getProdutosDoUsuario() {
        return produtosDoUsuario;
    }

}
