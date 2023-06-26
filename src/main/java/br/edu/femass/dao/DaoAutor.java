package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Autor;

public class DaoAutor extends Dao<Autor> {
    public static List<Autor> buscarTodos(){
        return em.createQuery("select c from Autor c").getResultList();
    }
}
