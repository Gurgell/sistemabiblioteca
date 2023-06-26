package br.edu.femass.controller;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoGenero;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Genero;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class GeneroController implements Initializable{
    DaoGenero daoGenero = new DaoGenero();
    Genero generoManipulacao;

    @FXML
    private TextField txt_nome;

    @FXML
    private ListView<Genero> listaGeneros;

    @FXML
    public void btn_gravar(ActionEvent event){
        try {
            Genero genero = new Genero(txt_nome.getText());

            daoGenero.inserir(genero);

            exibirGeneros();
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagemAlerta("Insira os dados necessários para gravar um gênero!", "Atenção!", "Erro ao gravar");
        }
        
    }

    @FXML
    public void btn_excluir(ActionEvent event){
        if (listaGeneros.getSelectionModel().getSelectedItem() != null){
            this.generoManipulacao = listaGeneros.getSelectionModel().getSelectedItem();
            System.out.println(this.generoManipulacao);
            daoGenero.apagar(generoManipulacao);

            exibirGeneros();
        }
        else{
            MensagensJavaFx.exibirMensagemAlerta("Selecione um gênero para excluir!", "Atenção!", "Erro ao excluir");
        }

    }

    public void exibirGeneros(){
        List<Genero> generos = DaoGenero.buscarTodos();

        ObservableList<Genero> data = FXCollections.observableArrayList(generos);
        listaGeneros.setItems(data);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirGeneros();
    }
}
