package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.model.Leitor;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class DaoLeitor extends Dao<Leitor>{
    public static List<Leitor> buscarTodos(){
        return em.createQuery("select c from Leitor c").getResultList();
    }

    public static Leitor buscarTipoLeitor(Long id){
        return  em.createQuery("select dtype from Leitor c WHERE c.id = :id ", Leitor.class)
        .setParameter("id", id)
        .getSingleResult();
    }

    public static void apagarLeitorPorUsuario(Long usuario_id){
        EntityManager em = emf.createEntityManager();
        EntityTransaction transaction = em.getTransaction();

        transaction.begin();
        
        em.createNativeQuery("DELETE from leitor where usuario_id = :usuario_id")
        .setParameter("usuario_id", usuario_id)
        .executeUpdate();

        transaction.commit();

        em.close();
    }
}
