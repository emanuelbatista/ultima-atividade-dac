package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.Resource;
import javax.ejb.Stateful;
import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.Queue;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Stateful
public class Carrinho {

    private Set<Produto> produtosDoUsuario = new HashSet<>();
    @Resource(lookup = "jms/connectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(lookup = "queue/pedido-queue")
    private Queue fila;
    
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
    }
    
    public void mensagemParaCartaoDeCredito(){
        try(JMSContext context = connectionFactory.createContext()){
        }
    }

}
