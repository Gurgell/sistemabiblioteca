package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class GeneroTest {

    private Genero genero;

    @BeforeEach
    public void Construtor() {
        genero = new Genero("Ficção");
    }

    @Test
    public void testGetId() {
        Assertions.assertNull(genero.getId());
    }

    @Test
    public void testGetNome() {
        Assertions.assertEquals("Ficção", genero.getNome());
    }

    @Test
    public void testSetNome() {
        genero.setNome("Aventura");
        Assertions.assertEquals("Aventura", genero.getNome());
    }

    @Test
    public void testGetLivros() {
        List<Livro> livros = new ArrayList<>();
        Livro livro1 = new Livro("Livro 1", 2023, "Edição 1", genero, new ArrayList<>());
        livros.add(livro1);
        genero.setLivro(livro1);

        Assertions.assertEquals(livros, genero.getLivros());
    }

}
