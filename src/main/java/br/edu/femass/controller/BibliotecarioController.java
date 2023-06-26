package br.edu.femass.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BibliotecarioController implements Initializable{

    @FXML
    public void btn_crud_livro(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Livro.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Livro");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_crud_autor(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Autor.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Autor");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_crud_genero(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Genero.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Genero");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_crud_copia(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Copia.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Copia");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_emprestimo(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Emprestimo.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Emprestimo");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_usuarios(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Usuario.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Usuário");
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    public void btn_leitor(ActionEvent event) throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/Leitor.fxml"));
        
        Scene scene = new Scene(root);

        Stage stage = new Stage();

        stage.setTitle("Leitor");
        stage.setScene(scene);
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
    
}
