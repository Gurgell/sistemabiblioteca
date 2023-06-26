package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class LivroTest {

    private Livro livro;
    private Genero genero;
    private List<Autor> autores;

    @BeforeEach
    public void Construtor() {
        genero = new Genero("Ficção");
        autores = new ArrayList<>();
        autores.add(new Autor("Fulano", "De tal"));
        autores.add(new Autor("Roberto", "Garcia"));

        livro = new Livro("Harry potter", 2023, "1ª edição", genero, autores);
    }

    @Test
    public void testGetNome() {
        Assertions.assertEquals("Harry potter", livro.getNome());
    }

    @Test
    public void testGetAno() {
        Assertions.assertEquals(2023, livro.getAno());
    }

    @Test
    public void testGetEdicao() {
        Assertions.assertEquals("1ª edição", livro.getEdicao());
    }

    @Test
    public void testGetGenero() {
        Assertions.assertEquals(genero, livro.getGenero());
    }

    @Test
    public void testGetAutores() {
        Assertions.assertEquals(autores, livro.getAutores());
    }

    @Test
    public void testAddCopia() {
        Copia copia = new Copia();
        livro.addCopia(copia);

        Assertions.assertTrue(livro.getCopias().contains(copia));
    }

}
