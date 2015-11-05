package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Startup;
import javax.enterprise.event.Observes;
import javax.ejb.Singleton;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Singleton
@Startup
@LocalBean
public class Produtos {

    private List<Produto> produtos = new ArrayList<>();
    @EJB
    private ProdutoService service;

    public void listener(@Observes Produto produto) {
        produtos = service.listar();
    }

    public List<Produto> getProdutos() {
        if (produtos == null || produtos.size() < 1)
            produtos = service.listar();
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public Produto getDestaque() {
        if (produtos.size() < 1)
            produtos = service.listar();
        return produtos.get(0);
    }

}
