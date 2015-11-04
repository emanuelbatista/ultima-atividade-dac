package edu.ifpb.dac.ejb;

import edu.ifpb.dac.Produto;
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
    
//    TODO: criar DAO de produto
    
    public void salvar(Produto produto){
//        TODO: chamar método do DAO para salvar
        evento.fire(produto);
    }
    
    public List<Produto> listar (){
//        TODO: chamar método DAO listar
        return null;
    }
}
