package br.edu.femass.model;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Aluno extends Leitor{
    private String matricula;

    public Aluno(String nome, String telefone, String email, String matricula, Usuario usuario){
        super(nome, telefone, email, usuario);

        this.matricula = matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }
    public void setMatricula(String matricula){
        this.matricula = matricula;
    }

    @Override
    public String toString(){
        return "Nome: " + this.getNome() +
        "\nMatricula: " + this.matricula +
        "\nEmail: " + this.getEmail();
    }
}
