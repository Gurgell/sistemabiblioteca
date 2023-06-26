package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoCopia;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Copia;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;

public class CopiaController implements Initializable{
    private DaoCopia daoCopia = new DaoCopia();
    private DaoLivro daoLivro = new DaoLivro();
    private Copia copiaManipulacao;

    @FXML
    private ComboBox<Livro> cbo_livro;

    @FXML
    private ListView<Copia> listaCopias;


    @FXML
    public void btn_gravar(ActionEvent event){
        try {
            Livro livro = cbo_livro.getSelectionModel().getSelectedItem();

            if (livro == null){
            MensagensJavaFx.exibirMensagem("Você deve selecionar um livro para gravar uma cópia", "Atenção! Erro ao gravar cópia", "Erro");
            return;
            }
            Copia copia = new Copia(livro);

            daoCopia.inserir(copia);
            DaoLivro.inserirCopiaLivro(livro.getId(), copia.getId());

            exibirLivros();
            exibirCopias();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Insira os dados necessários para gravar uma cópia!", "Atenção!", "Erro ao gravar");
        }
        
    }

    @FXML
    public void btn_excluir(ActionEvent event){
        if (listaCopias.getSelectionModel().getSelectedItem() != null){
            this.copiaManipulacao = listaCopias.getSelectionModel().getSelectedItem();
            
            DaoLivro.apagarCopiaDoLivro(copiaManipulacao.getLivro().getId(), copiaManipulacao.getId());
            DaoCopia.apagarCopia(copiaManipulacao.getId());

            exibirLivros();
            exibirCopias();
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione um gênero para excluir!", "Atenção!", "Erro ao excluir");
        }

    }

    public void exibirLivros(){
        List<Livro> livros = DaoLivro.buscarTodos();

        ObservableList<Livro> data = FXCollections.observableArrayList(livros);
        cbo_livro.setItems(data);
    }

    public void exibirCopias(){
        List<Copia> copias = DaoCopia.buscarTodos();

        ObservableList<Copia> data = FXCollections.observableArrayList(copias);
        listaCopias.setItems(data);

    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirCopias();
        exibirLivros();
    }
}
