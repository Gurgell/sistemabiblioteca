package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoAutor;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Autor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class AutorController implements Initializable{
    private DaoAutor daoAutor = new DaoAutor();
    private Autor AutorManipulacao;

    @FXML
    private TextField txt_nome;

    @FXML
    private TextField txt_sobreNome;

    @FXML
    private ListView<Autor> listaAutores;

    @FXML
    public void btn_gravar(ActionEvent event){
        try {
            Autor autor = new Autor(txt_nome.getText(), txt_sobreNome.getText());

            daoAutor.inserir(autor);

            exibirAutores();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Insira os dados necessários para gravar um autor!", "Atenção!", "Erro ao gravar");
        }
        
    }

    @FXML
    public void btn_excluir(ActionEvent event){
        if (listaAutores.getSelectionModel().getSelectedItem() != null){
            this.AutorManipulacao = listaAutores.getSelectionModel().getSelectedItem();
            System.out.println(this.AutorManipulacao);
            daoAutor.apagar(AutorManipulacao);

            exibirAutores();
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione um autor para excluir!", "Atenção!", "Erro ao excluir");
        }

    }

    public void exibirAutores(){
        List<Autor> autores = daoAutor.buscarTodos();

        ObservableList<Autor> data = FXCollections.observableArrayList(autores);
        listaAutores.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirAutores();
    }

    
}
