package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

public class EmprestimoTest {

    private Emprestimo emprestimo;
    private Copia copia;
    private Leitor leitor;

    @BeforeEach
    public void Construtor() {
        copia = new Copia();
        leitor = new Leitor("João", "123456789", "joao@example.com", new Usuario("hamilton", "12", true));

        emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusMonths(1), copia, leitor);
    }

    @Test
    public void testGetLeitor() {
        Assertions.assertEquals(leitor, emprestimo.getLeitor());
    }

    @Test
    public void testGetCopia() {
        Assertions.assertEquals(copia, emprestimo.getCopia());
    }

    @Test
    public void testGetData() {
        LocalDate expectedData = LocalDate.now();
        Assertions.assertEquals(expectedData, emprestimo.getData());
    }

    @Test
    public void testGetDataPrevistaEntrega() {
        LocalDate expectedDataPrevistaEntrega = LocalDate.now().plusMonths(1);
        Assertions.assertEquals(expectedDataPrevistaEntrega, emprestimo.getDataPrevistaEntrega());
    }

    @Test
    public void testSetData() {
        LocalDate newData = LocalDate.of(2023, 6, 10);
        emprestimo.setData(newData);

        Assertions.assertEquals(newData, emprestimo.getData());
    }

}


