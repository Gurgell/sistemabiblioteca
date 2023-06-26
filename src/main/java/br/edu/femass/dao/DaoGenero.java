package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Genero;

public class DaoGenero extends Dao<Genero> {
    public static List<Genero> buscarTodos(){
        return em.createQuery("select c from Genero c").getResultList();
    }
}
