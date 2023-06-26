package br.edu.femass.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Professor extends Leitor{
    private String formacao;

    public Professor(String nome, String telefone, String email, String formacao, Usuario usuario){
        super(nome, telefone, email, usuario);

        this.formacao = formacao;
    }

    public String getFormacao(){
        return this.formacao;
    }
    public void setformacao(String formacao){
        this.formacao = formacao;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() +
        "\nFormação: " + this.formacao +
        "\nEmail: " + this.getEmail();
    }
}
