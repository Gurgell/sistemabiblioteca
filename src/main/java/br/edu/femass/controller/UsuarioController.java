package br.edu.femass.controller;

import java.net.URL;
import java.util.ResourceBundle;

import br.edu.femass.dao.Dao;
import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoUsuario;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UsuarioController implements Initializable{

    private Usuario usuarioManipulacao;
    DaoUsuario daoUsuario = new DaoUsuario();

    @FXML
    private TextField txtLogin;

    @FXML
    private CheckBox admin;

    @FXML
    private PasswordField txtSenha;

    @FXML
    private ListView<Usuario> lista_usuarios;

    @FXML
    public void btn_cadastrar(ActionEvent event){
        try {
            if (DaoUsuario.buscarSeExisteUsuario(txtLogin.getText()) == null){
                usuarioManipulacao = new Usuario(txtLogin.getText(), txtSenha.getText(), admin.isSelected());

                daoUsuario.inserir(usuarioManipulacao);

            }else{
                MensagensJavaFx.exibirMensagemAlerta("Usuário já existente!", "Atenção!", "Erro ao criar usuário");   
            }
            limparDados();
            exibirUsuarios();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        
    }

    @FXML
    public void btn_excluir(ActionEvent event){
        try {
            if (lista_usuarios.getSelectionModel().getSelectedItem() != null){
            usuarioManipulacao = lista_usuarios.getSelectionModel().getSelectedItem();

            DaoLeitor.apagarLeitorPorUsuario(usuarioManipulacao.getId());
            daoUsuario.apagar(usuarioManipulacao);

            exibirUsuarios();
            limparDados();
            }else{
                MensagensJavaFx.exibirMensagemAlerta("Selecione um usuário para excluir!", "Atenção!", "Erro ao excluir");
            }
        } catch (Exception e) {
            MensagensJavaFx.exibirMensagem("Não foi possível excluir o usuário selecionado. Possivelmente ele ainda tem um empréstimo em seu nome!", "Atenção", "Erro");
        }
        
    }

    //#region Funções para limpar e exibir dados

    public void exibirUsuarios(){
        lista_usuarios.setItems(FXCollections.observableArrayList(DaoUsuario.buscarTodos()));
    }

    public void limparDados(){
        txtLogin.setText("");
        txtSenha.setText("");
    }
    //#endregion

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirUsuarios();
    }
    
}
