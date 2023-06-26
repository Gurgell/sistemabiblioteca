package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoLivro extends Dao<Livro> {
    public static List<Livro> buscarTodos(){
        return em.createQuery("select c from Livro c").getResultList();
    }

    public static void apagarCopiaDoLivro(Long livro_id, Long copias_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("DELETE FROM livro_copia WHERE livro_id = :livro_id  AND copias_id = :copias_id")
        .setParameter("livro_id", livro_id)
        .setParameter("copias_id", copias_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static void inserirCopiaLivro(Long livro_id, Long copias_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("INSERT into livro_copia (livro_id, copias_id) VALUES (:livro_id, :copias_id)")
        .setParameter("livro_id", livro_id)
        .setParameter("copias_id", copias_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }


}



