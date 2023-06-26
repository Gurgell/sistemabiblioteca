package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProfessorTest {
    @Test
    public void testConstrutor() {
        Usuario usuario = new Usuario();
        Aluno aluno = new Aluno("Marcelo", "123456789", "marcelo@marcelo.com", "23424", usuario);

        Assertions.assertEquals("23424", aluno.getMatricula());
        Assertions.assertEquals("marcelo@marcelo.com", aluno.getEmail());
        Assertions.assertEquals("123456789", aluno.getTelefone());
    }

    @Test
    public void testHerancaDeLeitor() {
        // Criação do objeto Aluno com herança da classe Leitor
        Aluno aluno = new Aluno("Maria", "987654321", "maria@example.com", "maria123", new Usuario("sdssd", "dsfdfssdc", false));

        // Verificação dos atributos herdados da classe Leitor
        Assertions.assertEquals("Maria", aluno.getNome());
        Assertions.assertEquals("987654321", aluno.getTelefone());
        Assertions.assertEquals("maria@example.com", aluno.getEmail());
        Assertions.assertEquals("sdssd", aluno.getUsuario().getLogin());
    }
}
