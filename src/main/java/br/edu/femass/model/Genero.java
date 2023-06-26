package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Genero {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @OneToMany
    private List<Livro> livros = new ArrayList<>();

    public Genero(String nome){
        this.nome = nome;
    }

    //#region Getters and Setters
    public Long getId(){
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
        return "Nome: " + this.nome;
    }
}
