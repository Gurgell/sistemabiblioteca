package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Copia;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Livro;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoCopia extends Dao<Copia> {
    public static List<Copia> buscarTodos(){
        return em.createQuery("select c from Copia c").getResultList();
    }

    public static void apagarCopia(Long copia_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("DELETE FROM copia WHERE id = :copia_id")
        .setParameter("copia_id", copia_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static void inserirEmprestadaCopia(Long id, Boolean emprestado){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("UPDATE copia SET emprestado = :emprestado WHERE id = :id")
        .setParameter("emprestado", emprestado)
        .setParameter("id", id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }

    public static List<Copia> buscarCopiaPorLivro(Long id){
        return em.createQuery("SELECT c FROM Copia c WHERE c.livro.id = :livro_id AND emprestado = false AND c.copiaBiblioteca = false", Copia.class)
        .setParameter("livro_id", id)
        .getResultList();
    }

    public static List<Copia> buscarMaisDeUmaCopia(Long livro_id){
        return em.createQuery("SELECT c FROM Copia c WHERE c.livro.id = :livro_id", Copia.class)
        .setParameter("livro_id", livro_id)
        .getResultList();
    }


}
