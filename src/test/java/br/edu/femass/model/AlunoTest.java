package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AlunoTest {

    @Test
    public void testConstrutor() {
        // Criação do objeto Aluno com herança da classe Leitor
        Aluno aluno = new Aluno("Maria", "987654321", "maria@maria", "maria123", new Usuario("sdssd", "dsfdfssdc", false));

        // Verificação dos atributos herdados da classe Leitor
        Assertions.assertEquals("Maria", aluno.getNome());
        Assertions.assertEquals("987654321", aluno.getTelefone());
        Assertions.assertEquals("maria@maria", aluno.getEmail());
        Assertions.assertEquals("sdssd", aluno.getUsuario().getLogin());
    }
}
