/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.ifpb.dac.dao;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Emanuel Batista da Silva Filho - emanuelbatista2011@gmail.com
 * @param <C>
 * @param <T>
 */
@Stateless
public class GenericoDAO<C, T> {

    @PersistenceContext
    private EntityManager entityManager;

    public void salvar(T t) {
        entityManager.persist(t);
    }

    public void atualizar(T t) {
        entityManager.merge(t);
    }

    public void remover(T t) {
        entityManager.remove(t);
    }

    public T pesquisar(C c, Class<T> clazz) {
        return entityManager.find(clazz, c);
    }

    public List<T> consultarLista(Class<T> clazz, String nameQuery, Map<String, Object> propriedades) {
        Query query = entityManager.createNamedQuery(nameQuery);
        Optional<Map<String, Object>> opt=Optional.of(propriedades);
        opt.ifPresent((t) -> {
            t.forEach((x,y)->{
                query.setParameter(x, y);
            });
        });
        return query.getResultList();
    }
}
