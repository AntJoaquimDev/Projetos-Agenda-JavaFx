package controller;

import agendaDao.UsuarioDao;
import agendaModel.Contato;
import agendaModel.TipoContato;
import agendaModel.Usuario;
import agendaUtil.Alerta;
import agendaUtil.ValidarCampo;
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
        if (ValidarCampo.chegcarcampoVazio(tfUsuario)) {
            Usuario objeto = new Usuario();
//     testar se o campo Id esta selecionado ou nao. se sim ele altera se nao ele inclui nova registro
            if (objeto != null) {
                objeto.setId(objeto.getId());   // apenas isso para alterar Tipo contato
            }
            objeto.getDescricao(tfUsuario.getText());
            if (dao.salvar(objeto)) {
                Alerta.msgInformacao("Registro Gravado com Sucesso");
            } else {
                Alerta.msgInformacao("Erro ao tentar gravar o registro");
            }
            //lbltext1.setText("Tipo de Contato Cadastrado ");
            tfId.clear();
            tfUsuario.clear();

        }
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitulo.setText("Cadastro Usuário");
    }

    public void cliccarTabela(MouseEvent mouseEvent) {
    }
}
