package edu.ifpb.dac.ejb.manage.bean;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.Carrinho;
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
public class CarrinhoController implements Serializable{

    @EJB
    private Carrinho carrinho;
    private Produto produto;
    
    public void addProduto(){
        carrinho.addProduto(produto);
    }
    
}
