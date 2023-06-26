package br.edu.femass.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import br.edu.femass.dao.DaoLeitor;
import br.edu.femass.dao.DaoLivro;
import br.edu.femass.dao.DaoUsuario;
import br.edu.femass.diversos.MensagensJavaFx;
import br.edu.femass.model.Aluno;
import br.edu.femass.model.Leitor;
import br.edu.femass.model.Professor;
import br.edu.femass.model.Usuario;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;

public class LeitorController implements Initializable{

    private Professor professorManipulacao;
    private Aluno alunoManipulacao;
    private DaoLeitor daoLeitor = new DaoLeitor();
    private List<String> tiposLeitores = new ArrayList<String>() {{
        add("Professor");
        add("Aluno");
    }};

    @FXML
    private ListView<Leitor> listaLeitores;

    @FXML
    private ComboBox<Usuario> cbo_usuarios;

    @FXML
    private ComboBox<String> cboTipoLeitor;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtEmail;

    @FXML
    private TextField txtMatricula;

    @FXML
    private TextField txtFormacao;

    @FXML
    private TextField txtTelefone;

    public void exibirLeitores(){
        listaLeitores.setItems(FXCollections.observableArrayList(DaoLeitor.buscarTodos()));
    }

    public void exibirTipoLeitores(){
        cboTipoLeitor.setItems(FXCollections.observableArrayList(tiposLeitores));
    }

    public void exibirUsuarios(){
        cbo_usuarios.setItems(FXCollections.observableArrayList(DaoUsuario.buscarTodos()));
    }

    @FXML
    public void btn_leitor(ActionEvent event){
        try {
            if (cbo_usuarios.getSelectionModel().getSelectedItem() == null){
                MensagensJavaFx.exibirMensagem("Selecione um usuário para cadastrar um leitor", "Atenção!", "Erro");
                return;
            }
            else if(cboTipoLeitor.getSelectionModel().getSelectedItem() == "Professor"){
                professorManipulacao = new Professor(txtNome.getText(),txtTelefone.getText() , txtEmail.getText(), txtFormacao.getText(), cbo_usuarios.getSelectionModel().getSelectedItem());
                daoLeitor.inserir(professorManipulacao);
            }
            else if(cboTipoLeitor.getSelectionModel().getSelectedItem() == "Aluno"){
                alunoManipulacao = new Aluno(txtNome.getText(),txtTelefone.getText() , txtEmail.getText(), txtMatricula.getText(), cbo_usuarios.getSelectionModel().getSelectedItem());
                daoLeitor.inserir(alunoManipulacao);
            }
            else{
                MensagensJavaFx.exibirMensagem("Selecione um tipo de leitor para cadastrar um leitor", "Atenção!", "Erro");
            }
            exibirUsuarios();
            exibirLeitores();
            exibirTipoLeitores();
        } catch (Exception e) {
            System.out.println(e.toString());
            MensagensJavaFx.exibirMensagem("Um usuário só pode ser um leitor!", "Atenção!", "Erro");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        exibirLeitores();
        exibirTipoLeitores();
        exibirUsuarios();

        cboTipoLeitor.setOnAction(event -> {
            if (cboTipoLeitor.getSelectionModel().getSelectedItem() == "Professor"){
                txtMatricula.setDisable(true);
                txtMatricula.setText("");
                txtFormacao.setDisable(false);
            }else{
                txtMatricula.setDisable(false);
                txtFormacao.setDisable(true);
                txtFormacao.setText("");
            }
        });
    }
    
}
