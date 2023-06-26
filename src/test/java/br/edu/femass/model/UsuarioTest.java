package br.edu.femass.model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {

    private Usuario usuario;
    private Leitor leitor;

    @BeforeEach
    public void Construtor() {
        leitor = new Leitor("roberto", "123456789", "roberto@roberto", usuario = new Usuario("roberto", "12345", true));
        usuario.setLeitor(leitor);
    }

    @Test
    public void testGetLogin() {
        Assertions.assertEquals("roberto", usuario.getLogin());
    }

    @Test
    public void testGetSenha() {
        Assertions.assertEquals("12345", usuario.getSenha());
    }

    @Test
    public void testGetAdmin() {
        Assertions.assertTrue(usuario.getAdmin());
    }

    @Test
    public void testGetLeitor() {
        Assertions.assertEquals(leitor, usuario.getLeitor());
    }

    @Test
    public void testToString() {
        Assertions.assertEquals("Usuário: roberto", usuario.toString());
    }
}
