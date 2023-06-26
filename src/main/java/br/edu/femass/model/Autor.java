package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String sobreNome;

    @ManyToMany
    private List<Livro> livros = new ArrayList<>();

    public Autor(String nome, String sobreNome){
        this.nome = nome;
        this.sobreNome = sobreNome;
    }

    //#region Getters and Setters
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobreNome() {
        return sobreNome;
    }

    public void setSobreNome(String sobreNome) {
        this.sobreNome = sobreNome;
    }

    public void setLivro(Livro livro){
        livros.add(livro);
    }

    public List<Livro> getLivros(){
        return livros;
    }
    //#endregion

    @Override
    public String toString(){
        return "nome: " + this.nome + " " + this.sobreNome;
    }
}
