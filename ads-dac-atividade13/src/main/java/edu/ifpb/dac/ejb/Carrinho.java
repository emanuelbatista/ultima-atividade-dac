package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.manage.bean.produtor.jms.Produtor;
import java.util.HashSet;
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
    @EJB
    private Produtor produtor;
   
    
    public void addProduto (Produto produto){
        produtosDoUsuario.add(produto);
    }
    
    public void removeProduto (Produto produto){
        produtosDoUsuario.remove(produto);
    }

    public Set<Produto> getProdutosDoUsuario() {
        return produtosDoUsuario;
    }
    
    public void cancelarPedido (){
        this.produtosDoUsuario = new HashSet<>();
    }
    
    public void confirmarPedido(){
//        TODO: lógica de confirmar pedido
        produtor.enviarMensagem("Ok");
    }
    
    

}
