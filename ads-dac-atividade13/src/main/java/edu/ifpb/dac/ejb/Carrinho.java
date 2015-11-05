package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.manage.bean.produtor.jms.Produtor;
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

    private List<Produto> produtosDoUsuario = new ArrayList<>();
    @EJB
    private Produtor produtor;

    public void addProduto(Produto produto) {
        produtosDoUsuario.add(produto);
    }

    public void removeProduto(Produto produto) {
        produtosDoUsuario.remove(produto);
    }

    public List<Produto> getProdutosDoUsuario() {
        return produtosDoUsuario;
    }

    public void cancelarPedido() {
        this.produtosDoUsuario = new ArrayList<>();
    }

    public void confirmarPedido() {
        this.produtosDoUsuario = new ArrayList<>();
        produtor.enviarMensagem("Ok");
    }

}
