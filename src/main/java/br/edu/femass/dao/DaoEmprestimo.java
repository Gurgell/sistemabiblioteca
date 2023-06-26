package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Emprestimo;

public class DaoEmprestimo extends Dao<Emprestimo>{
    public static List<Emprestimo> buscarTodos(){
        return em.createQuery("SELECT c FROM Emprestimo c", Emprestimo.class).getResultList();
    }

    public static List<Emprestimo> buscarEmprestimoPorLeitor(Long id){
        return em.createQuery("SELECT c FROM Emprestimo c WHERE c.leitor.id = :leitor_id", Emprestimo.class)
            .setParameter("leitor_id", id)
            .getResultList();
    }

}
