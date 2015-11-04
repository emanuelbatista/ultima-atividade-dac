package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
import edu.ifpb.dac.dao.GenericoDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

/**
 *
 * @author douglasgabriel
 * @version 0.1
 */
@Stateless
public class ProdutoService {

    @Inject
    private Event<Produto> evento;
    @Inject
    private GenericoDAO<Integer,Produto> dao;
    
    public void salvar(Produto produto){
        dao.salvar(produto);
        evento.fire(produto);
    }
    
    public List<Produto> listar (){
        return dao.consultarLista("produto.listar");
    }
}
