package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

public class AutorTest {

    private Autor autor;

    @BeforeEach
    public void Construtor() {
        autor = new Autor("John", "Travolta");
    }

    @Test
    public void testGetId() {
        Assertions.assertNull(autor.getId());
    }

    @Test
    public void testGetNome() {
        Assertions.assertEquals("John", autor.getNome());
    }

    @Test
    public void testSetNome() {
        autor.setNome("Jane");
        Assertions.assertEquals("Jane", autor.getNome());
    }

    @Test
    public void testGetSobreNome() {
        Assertions.assertEquals("Travolta", autor.getSobreNome());
    }

    @Test
    public void testSetSobreNome() {
        autor.setSobreNome("Smith");
        Assertions.assertEquals("Smith", autor.getSobreNome());
    }

    @Test
    public void testSetLivro() {
        Livro livro = new Livro("Livro 1", 2021, "Edição 1", null, null);
        autor.setLivro(livro);
        List<Livro> livros = autor.getLivros();
        Assertions.assertEquals(1, livros.size());
        Assertions.assertEquals(livro, livros.get(0));
    }

    @Test
    public void testGetLivros() {
        List<Livro> livros = autor.getLivros();
        Assertions.assertNotNull(livros);
        Assertions.assertEquals(0, livros.size());
    }
}
