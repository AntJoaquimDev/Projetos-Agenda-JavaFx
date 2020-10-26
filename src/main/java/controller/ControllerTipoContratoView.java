package controller;

import agendaDao.CrudGenecDao;
import agendaDao.TipoContatoDao;
import agendaModel.TipoContato;
import agendaUtil.Alerta;
import agendaUtil.ValidarCampo;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerTipoContratoView implements Initializable, IntCadastro {

    @FXML
    private Label lbltext1;
    @FXML
    private Label lblTitulo;
    @FXML
    private JFXTextField tfId;

    @FXML
    private JFXTextField tfDescricao;

    @FXML
    private Button btnNovo;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnDeletar;

    @FXML
    private TextField tfPesquisar;

    @FXML
    private TableView<TipoContato> tbView;

    private CrudGenecDao<TipoContato> dao = new CrudGenecDao();

    private ObservableList<TipoContato> observableList = FXCollections.observableArrayList();
    private List<TipoContato> lista;
    private TipoContato objSelecionado = new TipoContato();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lblTitulo.setText("Cadastro Tipo Contato");
        ocultar();
        criarColunasTabela();
       // ValidarCampo.chegcarcampoVazio(tfDescricao);
        // tfDescricao.requestFocus();
        //atualizarTabela();
    }



    @FXML
    void incluirRegistro(ActionEvent event) {
        limparCamposFormes();
        ativar();
        tfDescricao.requestFocus();
    }

    @FXML
    void salvarRegistro(ActionEvent event) {
        if (ValidarCampo.chegcarcampoVazio(tfDescricao)) {
            TipoContato objeto = new TipoContato();
//     testar se o campo Id esta selecionado ou nao. se sim ele altera se nao ele inclui nova registro
            if (objSelecionado != null) {
                objeto.setId(objSelecionado.getId());   // apenas isso para alterar Tipo contato
            }
            objeto.setDescricaoTipo(tfDescricao.getText());
            if (dao.salvar(objeto)) {
                Alerta.msgInformacao("Registro Gravado com Sucesso");
            } else {
                Alerta.msgInformacao("Erro ao tentar gravar o registro");
            }
            //lbltext1.setText("Tipo de Contato Cadastrado ");
            tfId.clear();
            tfDescricao.clear();
            atualizarTabela();
        }
    }
    @FXML
    void deletarRegistro(ActionEvent event) {
        if (TipoContatoDao.liberarExlcusao(objSelecionado.getId())) {
            if (Alerta.msgConfimarExclusao(tfDescricao.getText())) {
                dao.excluis(objSelecionado);
                limparCamposFormes();
                atualizarTabela();
                Alerta.msgInformacao("Registro Excluído com Sucesso");
            }
        } else {
            Alerta.msgInformacao("Não Permitido. \n Cidade ja ultilizada em outro Cadastro");
        }
    }
    @Override
    public void criarColunasTabela() {

        TableColumn<TipoContato, Long> colunaId = new TableColumn<>("ID");
        TableColumn<TipoContato, String> colunaDescricao = new TableColumn<>("DESCRIÇÃO");
        tbView.getColumns().addAll(colunaId, colunaDescricao);
        // redimencionar as colunas na tabela
        colunaId.setMinWidth(40);
        colunaId.setMaxWidth(40);
        //dividar os campos daluna por igual na tabela
        tbView.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        colunaId.setCellValueFactory(new PropertyValueFactory<TipoContato, Long>("id"));
        colunaDescricao.setCellValueFactory(new PropertyValueFactory<TipoContato, String>("descricaoTipo"));
    }

    @Override
    public void atualizarTabela() {
        observableList.clear();
        lista = dao.consultar(tfPesquisar.getText(), "TipoContato");

        //percorrer cada registro na lista
        for (TipoContato t : lista) { //forEach
            observableList.add(t);
        }
        tbView.getItems().setAll(observableList);
        tbView.getSelectionModel().selectFirst();
    }

    @Override
    public void seteCamposFormes() {
        //pegar o objeto selecionado e preencher o form pelo index;;;;
        objSelecionado = tbView.getItems().get(tbView.getSelectionModel().getFocusedIndex());
        tfId.setText(String.valueOf(objSelecionado.getId()));
        tfDescricao.setText(String.valueOf(objSelecionado.getDescricaoTipo()));

    }

    @Override
    public void limparCamposFormes() {
        objSelecionado = null;
        lista.clear();
       //lbltext1.setText("");
        tfId.clear();
        tfDescricao.clear();
        tfDescricao.requestFocus();
    }

    @FXML
    void filtarRegistros(MouseEvent event) {
        atualizarTabela();
    }

    @FXML
    void filtarRegistros(KeyEvent event) {
        atualizarTabela();
    }

    @FXML
    void atualizarListaClick(MouseEvent event) {
        atualizarTabela();
    }


    @FXML
    void clicarSelecionar(MouseEvent event) {
        seteCamposFormes();
    }

    @FXML
    void moverTabela(KeyEvent event) {
        seteCamposFormes();
    }

    public void ocultar() {
        tfId.setDisable(true);
        tfDescricao.setDisable(true);
    }

    public void ativar() {
        tfId.setDisable(false);
        tfDescricao.setDisable(false);
    }

}

