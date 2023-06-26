package br.edu.femass.dao;

import java.util.List;

import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Copia;
import br.edu.femass.model.Usuario;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.TypedQuery;

public class DaoUsuario extends Dao<Usuario>{
    public static List<Usuario> buscarTodos(){
        return em.createQuery("select c from Usuario c").getResultList();
    }

    public static Usuario buscarSeExisteUsuario(String login){
        try {
            String queryStr = "SELECT u FROM Usuario u WHERE u.login = :login";
            TypedQuery<Usuario> query = em.createQuery(queryStr, Usuario.class);
            query.setParameter("login", login);

            List<Usuario> usuarios = query.getResultList();

            if (!usuarios.isEmpty()) {
                return usuarios.get(0);
            } else {
                return null;
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            return null;        
        }
    }

    public static Usuario buscarUsuarioParaLogin(String login){
        return em.createQuery("SELECT u FROM Usuario u WHERE u.login = :login", Usuario.class)
            .setParameter("login", login)
            .getSingleResult();
    }
}
