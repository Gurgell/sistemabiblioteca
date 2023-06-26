package br.edu.femass.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Livro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer ano;
    private String edicao;

    @ManyToOne
    private Genero genero;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Copia> copias = new ArrayList<>();

    @ManyToMany
    private List<Autor> autores = new ArrayList<>();

    public Livro(String nome, Integer ano, String edicao, Genero genero, List<Autor> autores){
        this.nome = nome;
        this.ano = ano;
        this.edicao = edicao;
        this.genero = genero;

        this.autores = autores;
    }

    //#region Getters and Setters

    public List<Copia> getCopias(){
        return copias;
    }

    public void addCopia(Copia copia){
        this.copias.add(copia);
    }

    public Long getId() {
        return this.id;
    }

    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAno() {
        return this.ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getEdicao() {
        return this.edicao;
    }

    public void setEdicao(String edicao) {
        this.edicao = edicao;
    }

    public Genero getGenero() {
        return this.genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public List<Autor> getAutores(){
        return this.autores;
    }
    //#endregion

    @Override
    public String toString(){
        return "Nome: " + this.nome +
        "\nAno: " + this.nome +
        "\nEdição: " + this.edicao +
        "\nGênero: " + this.genero.getNome() +
        "\nQuantidade de cópias: " + this.copias.size();
    }
}
