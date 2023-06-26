package br.edu.femass.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne (cascade = CascadeType.ALL)
    private Leitor leitor;

    private String login;
    private String senha;

    private Boolean admin;

    public Usuario(String login, String senha, Boolean admin){
        this.login = login;
        this.senha = senha;
        this.admin = admin;
    }

    public Long getId(){
        return this.id;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public Boolean getAdmin(){
        return this.admin;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public String getLogin() {
        return login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    @Override
    public String toString(){
        return "Usuário: " + this.login;
    }
}
