package br.edu.femass.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity
public class Emprestimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Copia copia;

    @ManyToOne
    private Leitor leitor;

    private LocalDate data;
    private LocalDate dataPrevistaEntrega;
    private LocalDate dataEntrega;

    public Emprestimo(LocalDate data, LocalDate dataPrevistaEntrega, Copia copia, Leitor leitor){
        this.data = data;
        this.dataPrevistaEntrega = dataPrevistaEntrega;
        this.copia = copia;
        this.leitor = leitor;
    }

    public Leitor getLeitor() {
        return leitor;
    }

    public void setLeitor(Leitor leitor) {
        this.leitor = leitor;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Long getId() {
        return id;
    }

    public Copia getCopia() {
        return copia;
    }

    public void setCopia(Copia copia) {
        this.copia = copia;
    }

    public LocalDate getData() {
        return data;
    }

    public LocalDate getDataPrevistaEntrega() {
        return dataPrevistaEntrega;
    }

    public void setDataPrevistaEntrega(LocalDate dataPrevistaEntrega) {
        this.dataPrevistaEntrega = dataPrevistaEntrega;
    }

    public LocalDate getDataEntrega() {
        return dataEntrega;
    }

    public void setDataEntrega(LocalDate dataEntrega) {
        this.dataEntrega = dataEntrega;
    }

    @Override
    public String toString(){
        return "Cópia número: " + this.getCopia().getId() + " do livro: "  + this.copia.getLivro().getNome() + 
        "\nData: " + this.data +
        "\nData Prevista para entrega: "+ this.dataPrevistaEntrega;
    }
    
}
