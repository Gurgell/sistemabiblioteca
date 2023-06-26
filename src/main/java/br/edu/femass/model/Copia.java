package br.edu.femass.model;

import java.util.List;

import br.edu.femass.dao.DaoCopia;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Copia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Boolean emprestado;

    private Boolean copiaBiblioteca;

    @OneToMany (cascade = CascadeType.ALL)
    private List<Emprestimo> emprestimos;

    @ManyToOne
    private Livro livro;

    public Copia(Livro livro){
        this.livro = livro;
        if (DaoCopia.buscarMaisDeUmaCopia(livro.getId()).size() < 1){
            this.copiaBiblioteca = true;
        }
        else{
            this.copiaBiblioteca = false;
        }
        this.emprestado = false;
    }

    public Boolean getEmprestado(){
        return this.emprestado;
    }

    public void setEmprestado(Boolean emprestado){
        this.emprestado = emprestado;
    }

    public Long getId(){
        return this.id;
    }

    public Livro getLivro(){
        return this.livro;
    }

    public String toString(){
        return "ID Cópia: " + this.id +
        "\nLivro: " + this.livro.getNome();
    }
}
