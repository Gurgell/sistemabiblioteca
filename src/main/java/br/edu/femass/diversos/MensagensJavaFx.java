package br.edu.femass.diversos;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;

public class MensagensJavaFx {
    public static void exibirMensagem (String mensagem, String header, String titulo){
        Alert alerta = new Alert(AlertType.ERROR);
        alerta.setHeaderText(header);
        alerta.setContentText(mensagem);
        alerta.setTitle(titulo);
        alerta.show();
    }

    public static void exibirMensagemAlerta (String mensagem, String header, String titulo){
        Alert alerta = new Alert(AlertType.WARNING);
        alerta.setHeaderText(mensagem);
        alerta.setContentText(mensagem);
        alerta.setTitle(mensagem);
        alerta.show();
    }

    public static Boolean exibirConfirmacao (String mensagem,String header, String titulo){
        Alert alerta = new Alert(AlertType.CONFIRMATION);
        alerta.setTitle(titulo);
        alerta.setHeaderText(header);
        alerta.setContentText(mensagem);
        
        ButtonType resultado = alerta.showAndWait().orElse(ButtonType.CANCEL);
        
        if (resultado == ButtonType.OK) {
            return true;
        } else {
            return false;
        }
    }

    public static void exibirMensagemSucesso (String mensagem){
        Alert alerta = new Alert(AlertType.INFORMATION);
        alerta.setTitle(mensagem);
        alerta.show();
    }

}
