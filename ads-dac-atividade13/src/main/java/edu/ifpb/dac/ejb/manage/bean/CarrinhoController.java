package edu.ifpb.dac.ejb.manage.bean;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.Carrinho;
import edu.ifpb.dac.ejb.Produtos;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
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
    @EJB
    private Produtos produtosDaBaseDeDados;
    
    public String addProduto(Produto produto){
        carrinho.addProduto(produto);
        return null;
    }
    
    public String removeProduto (Produto produto){
        carrinho.removeProduto(produto);
        return null;
    }
    
    public Produto getProdutoDestaque (){
        try{
            return produtosDaBaseDeDados.getDestaque();
        }catch (Exception e){
            return null;
        }
    }
    
    public List<Produto> getProdutos(){
        return produtosDaBaseDeDados.getProdutos();
    }
    
    public Set<Produto> getProdutosNoCarrinho(){
        return carrinho.getProdutosDoUsuario();
    }
}
