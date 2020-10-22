package controller;

import agendaDao.UsuarioDao;
import agendaModel.Contato;
import agendaModel.TipoContato;
import agendaModel.Usuario;
import com.jfoenix.controls.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerUsuarioView implements Initializable {



    private Button btnSalvar;

    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField tfId;

    @FXML
    private JFXTextField tfUsuario;

    @FXML
    private JFXPasswordField tfSenha;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnDeletar;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private TableView<Usuario> tbView;

    @FXML
    void deletarRegistro(ActionEvent event) {

    }

    @FXML
    void incluirRegistro(ActionEvent event) {

    }


    @FXML
    void moverTabela(KeyEvent event) {

    }

    @FXML
    void pesquisarRegistro(KeyEvent event) {

    }

    UsuarioDao dao = new UsuarioDao();

    @FXML
    void salvarRegistro(ActionEvent event) {

        Usuario usuario = new Usuario();
        usuario.setDescricao(tfUsuario.getText());
        usuario.setSenha(tfSenha.getText());
        dao.salvar(usuario);


    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
            lblTitulo.setText("Cadastro Usuário");
    }

    public void cliccarTabela(MouseEvent mouseEvent) {
    }
}
