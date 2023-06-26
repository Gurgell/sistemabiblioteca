package br.edu.femass.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoUsuario;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Usuario;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LoginController implements Initializable{

    @FXML
    private TextField txtLogin;

    DaoUsuario daoUsuario = new DaoUsuario();

    @FXML
    private PasswordField txtSenha;

    @FXML
    public void btn_entrar(ActionEvent event) throws IOException{
        try {
            Usuario usuario = DaoUsuario.buscarUsuarioParaLogin(txtLogin.getText());
            System.out.println(usuario);
            if (usuario == null){
                MensagensJavaFx.exibirMensagem("Usuário inexistente", "Atenção!","Erro!");
                return;
            }
            if (txtSenha.getText().equals(usuario.getSenha())){
                if(usuario.getAdmin()){
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/Bibliotecario.fxml"));
            
                    Scene scene = new Scene(root);

                    Stage stage = new Stage();

                    stage.setTitle("Bibliotecario");
                    stage.setScene(scene);
                    stage.show();
                }else{
                    Parent root = FXMLLoader.load(getClass().getResource("/fxml/LivroConsulta.fxml"));
            
                    Scene scene = new Scene(root);

                    Stage stage = new Stage();

                    stage.setTitle("Consulta de livros");
                    stage.setScene(scene);
                    stage.show();
                }
                
            }
            else{
                MensagensJavaFx.exibirMensagem("Senha ou usuário incorreto", "Atenção", "Erro");
            }
        } catch (Exception e) {
            System.out.println(e.toString());
            MensagensJavaFx.exibirMensagem("Usuário ou senha incorretos", "Atenção!", "Erro");
        }
        

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
    }
}
