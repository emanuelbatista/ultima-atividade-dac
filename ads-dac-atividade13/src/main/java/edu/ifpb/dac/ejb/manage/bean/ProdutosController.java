package edu.ifpb.dac.ejb.manage.bean;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.ejb.ProdutoService;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Named
@SessionScoped
public class ProdutosController implements Serializable{

    private String nome;
    private BigDecimal preco;
    @Inject
    private ProdutoService service;    
    
    public void criarProduto (){
        Produto produto = new Produto(nome, preco);
        service.salvar(produto);
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }
    
}
