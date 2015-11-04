package edu.ifpb.dac.ejb.manage.bean;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.ProdutoService;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
@SessionScoped
public class ProdutosController implements Serializable{

    private Produto produto;
    @EJB
    private ProdutoService service;    

    public ProdutosController() {
        produto=new Produto();
    }
    
    public void criarProduto (){
        service.salvar(produto);
        produto=new Produto();
    }
    
    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    
    
    
}
