package org.example.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import org.example.dao.DenunciaDAO;
import org.example.model.Denuncia;

public class DenunciaController {

    // ======== Elementos da Aba do Usuário ========
    @FXML private TextField txtTitulo;
    @FXML private TextArea txtDescricao;

    // ======== Elementos da Aba do Técnico ========
    @FXML private VBox painelLogin;
    @FXML private VBox painelGestao;
    @FXML private PasswordField txtSenha;
    @FXML private ListView<Denuncia> listViewDenuncias;

    private DenunciaDAO dao = new DenunciaDAO();
    private final String SENHA_TECNICO = "admin123"; // <<< SUA SENHA FIXA AQUI

    @FXML
    public void initialize() {
        atualizarLista();
    }

    // ======== Lógica do Usuário ========
    @FXML
    public void salvarDenuncia() {
        String titulo = txtTitulo.getText();
        String descricao = txtDescricao.getText();

        if (!titulo.isEmpty() && !descricao.isEmpty()) {
            Denuncia d = new Denuncia(titulo, descricao, "Aberto");
            dao.salvar(d);
            atualizarLista();

            txtTitulo.clear();
            txtDescricao.clear();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Sucesso");
            alert.setHeaderText(null);
            alert.setContentText("Ocorrência registrada e enviada ao setor técnico!");
            alert.showAndWait();
        }
    }

    // ======== Lógica de Login do Técnico ========
    @FXML
    public void verificarSenha() {
        if (txtSenha.getText().equals(SENHA_TECNICO)) {
            // Se a senha estiver correta, esconde o login e mostra a gestão
            painelLogin.setVisible(false);
            painelLogin.setManaged(false); // Faz o login não ocupar mais espaço

            painelGestao.setVisible(true);
            painelGestao.setManaged(true);

            txtSenha.clear();
        } else {
            // Se errar a senha
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Acesso Negado");
            alert.setHeaderText(null);
            alert.setContentText("Senha incorreta! Acesso restrito aos técnicos.");
            alert.showAndWait();
            txtSenha.clear();
        }
    }

    // ======== Lógica de Gestão do Técnico ========
    @FXML
    public void marcarEmAnalise() {
        atualizarStatusSelecionado("Em Análise");
    }

    @FXML
    public void marcarResolvido() {
        atualizarStatusSelecionado("Resolvido");
    }

    private void atualizarStatusSelecionado(String novoStatus) {
        Denuncia selecionada = listViewDenuncias.getSelectionModel().getSelectedItem();
        if (selecionada != null) {
            dao.atualizarStatus(selecionada.getId(), novoStatus);
            atualizarLista();
        } else {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Atenção");
            alert.setHeaderText(null);
            alert.setContentText("Selecione uma denúncia na lista primeiro.");
            alert.showAndWait();
        }
    }

    private void atualizarLista() {
        listViewDenuncias.getItems().clear();
        listViewDenuncias.getItems().addAll(dao.listarTodas());
    }
}