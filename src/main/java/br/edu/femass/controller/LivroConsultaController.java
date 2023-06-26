package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.dao.DaoGenero;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.model.Autor;
import br.edu.femass.model.Genero;
import br.edu.femass.model.Livro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class LivroConsultaController implements Initializable {
    private DaoLivro daoLivro = new DaoLivro();
    
    //#region Atributos javafx
    @FXML
    private ListView<Livro> listaLivros;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_ano;

    @FXML
    private TextField txt_edicao;

    @FXML
    private ComboBox<Genero> combo_genero;

    @FXML
    private ListView<Autor> lista_autores;

    //#endregion
    
    private Livro livroManipulacao;

    
    //#region Buscar e exibições
    @FXML
    private void listaLivros_keyPressed(KeyEvent event){
        exibirDados();
    }
    @FXML
    private void listaLivros_mouseClicked(MouseEvent event){
        exibirDados();
    }

    @FXML
    public void btn_limpar(){
        limparCampos();
    }
    
    public void limparCampos(){
        txt_nome.setText("");
        txt_ano.setText("");
        txt_edicao.setText("");
        combo_genero.setValue(null);
        buscarGeneros();
        buscarAutores();
    }

    public void buscarGeneros(){
        ObservableList<Genero> data = FXCollections.observableArrayList(DaoGenero.buscarTodos());
        combo_genero.setItems(data);
    }

    public void buscarAutores(){
        ObservableList<Autor> data = FXCollections.observableArrayList(DaoAutor.buscarTodos());
        lista_autores.setItems(data);
    }

    public void exibirLivros(){
        listaLivros.setItems(FXCollections.observableArrayList(DaoLivro.buscarTodos()));
    }

    public void exibirDados(){
        if (listaLivros.getSelectionModel().getSelectedItem() != null){
            livroManipulacao = listaLivros.getSelectionModel().getSelectedItem();

            txt_nome.setText(livroManipulacao.getNome());
            txt_ano.setText(livroManipulacao.getAno().toString());
            txt_edicao.setText(livroManipulacao.getEdicao());

            ObservableList<Autor> dataAutor = FXCollections.observableArrayList(livroManipulacao.getAutores());
            lista_autores.setItems(dataAutor);

            combo_genero.setValue(livroManipulacao.getGenero());
        }
    }

    
    public void desabilitarDados(){
        txt_nome.setDisable(true);
        txt_ano.setDisable(true);
        txt_edicao.setDisable(true);
        lista_autores.setDisable(true);
        combo_genero.setDisable(true);
    }
    //#endregion

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        lista_autores.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        buscarAutores();
        buscarGeneros();
        exibirLivros();
        exibirDados();

        desabilitarDados();
    }    
}
