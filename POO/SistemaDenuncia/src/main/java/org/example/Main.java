package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carrega o arquivo visual que criamos na pasta resources
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/tela.fxml"));

        // Define o tamanho da janela (largura 400, altura 550)
        Scene scene = new Scene(loader.load(), 400, 550);

        primaryStage.setTitle("MVP - Sistema de Denúncias");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        // Dispara a interface gráfica do JavaFX
        launch(args);
    }
}