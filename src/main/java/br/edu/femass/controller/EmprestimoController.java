package br.edu.femass.controller;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import javax.swing.Action;

import br.edu.femass.dao.DaoCopia;
import br.edu.femass.dao.DaoEmprestimo;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Copia;
import br.edu.femass.model.Emprestimo;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Livro;
import br.edu.femass.model.Professor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class EmprestimoController implements Initializable{

    //#region atributos e variáveis
    private DaoEmprestimo daoEmprestimo = new DaoEmprestimo();
    private DaoCopia daoCopia = new DaoCopia();
    private Emprestimo emprestimoManipulacao;

    @FXML
    private ListView<Emprestimo> listaEmprestimos;

    @FXML
    private Button btn_emprestimo;

    @FXML
    private ComboBox<Livro> cbo_Livros;

    @FXML
    private ComboBox<Copia> cbo_Copias;

    @FXML
    private ComboBox<Leitor> cbo_leitor;


    //#endregion

    //#region CRUD
    @FXML
    public void btn_emprestimo(ActionEvent event){
        try {
            Livro livro = cbo_Livros.getSelectionModel().getSelectedItem();
            Copia copia = cbo_Copias.getSelectionModel().getSelectedItem();
            Leitor leitor = cbo_leitor.getSelectionModel().getSelectedItem();

            

            if (livro == null || copia == null || leitor == null){
            MensagensJavaFx.exibirMensagem("Você deve selecionar um livro, uma cópia e um leitor para realizar um empréstimo", "Atenção! Erro ao gravar empréstimo", "Erro");
            return;
            }

            if (leitor instanceof Professor){
                Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusMonths(1), copia, leitor);
                daoEmprestimo.inserir(emprestimo);
            }
            else if (leitor instanceof Aluno){
                Emprestimo emprestimo = new Emprestimo(LocalDate.now(), LocalDate.now().plusDays(5), copia, leitor);
                daoEmprestimo.inserir(emprestimo);
            }

            DaoCopia.inserirEmprestadaCopia(copia.getId(), true);
            
            exibirLivros();
            exibirLeitores();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Insira os dados necessários para gravar uma empréstimo!", "Atenção!", "Erro ao gravar");
            System.out.println(e.toString());
        }
        
    }

    @FXML
    public void btn_devolverCopia(ActionEvent event){
        try {
            if (listaEmprestimos.getSelectionModel().getSelectedItem() == null){
                MensagensJavaFx.exibirMensagem("Você deve selecionar um empréstimo para realizar uma devolução de cópia", "Atenção! Erro ao devolver cópia", "Erro");
                return;
            }
            emprestimoManipulacao = listaEmprestimos.getSelectionModel().getSelectedItem();
            DaoCopia.inserirEmprestadaCopia(emprestimoManipulacao.getCopia().getId(), false);

            daoEmprestimo.apagar(emprestimoManipulacao);

            exibirLivros();
            exibirLeitores();
            exibirTodosEmprestimos();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Insira os dados necessários para gravar uma empréstimo!", "Atenção!", "Erro ao gravar");
            System.out.println(e.toString());
        }
    }

    @FXML
    public void btn_limpar(ActionEvent event){
        cbo_Copias.setValue(null);
        cbo_Livros.setValue(null);
        cbo_leitor.setValue(null);
        listaEmprestimos.setItems(null);
    }

    @FXML
    public void btn_exibirTodos(ActionEvent event){
        exibirTodosEmprestimos();
    }
    //#endregion

    //#region exibir dados
    public void exibirLivros(){
        List<Livro> livros = DaoLivro.buscarTodos();
        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        cbo_Livros.setItems(data);
    }

    public void exibirCopias(){
        try {    
            Livro livro = cbo_Livros.getSelectionModel().getSelectedItem();
            List<Copia> copias = DaoCopia.buscarCopiaPorLivro(livro.getId());
            ObservableList<Copia> data = FXCollections.observableArrayList(copias);
            cbo_Copias.setItems(data);
        } catch (Exception e) {
            System.out.println(e.toString());
        }
    }

    public void exibirLeitores(){
        List<Leitor> leitores = DaoLeitor.buscarTodos();

        ObservableList<Leitor> data = FXCollections.observableArrayList(leitores);
        cbo_leitor.setItems(data);
    }

    public void exibirTodosEmprestimos(){
        List<Emprestimo> emprestimos = DaoEmprestimo.buscarTodos();
        ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
        listaEmprestimos.setItems(data);
    }

    public void exibirEmprestimosPorLeitor(){
        try {
            Leitor leitorSelecionado = cbo_leitor.getSelectionModel().getSelectedItem();
            List<Emprestimo> emprestimos =  DaoEmprestimo.buscarEmprestimoPorLeitor(leitorSelecionado.getId());

            ObservableList<Emprestimo> data = FXCollections.observableArrayList(emprestimos);
            listaEmprestimos.setItems(data);

        } catch (Exception e) {
            System.out.println(e.toString());
        }
        

    }
    //#endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirLivros();
        exibirLeitores();

        cbo_Livros.setOnAction(event -> {
            exibirCopias();
        });

        cbo_leitor.setOnAction(event -> {
            exibirEmprestimosPorLeitor();
        });
    }
    
}
