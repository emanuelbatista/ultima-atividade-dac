package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.event.Observes;
import javax.inject.Singleton;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Singleton
public class Produtos {

    private List<Produto> produtos = new ArrayList<>();
    private Produto destaque;
    @EJB
    private ProdutoService service;

    public void listener (@Observes Produto produto){
        produtos = service.listar();
    }
    
    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getDestaque() {
        return destaque;
    }

    public void setDestaque(Produto destaque) {
        this.destaque = destaque;
    }
    
}
